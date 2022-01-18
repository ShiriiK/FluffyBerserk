package en.fluffyBerserk.game.gamecontrolls;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.logic.Animated;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.maps.Map2;
import en.fluffyBerserk.game.logic.maps.Map1;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.MovableEntity;
import en.fluffyBerserk.game.logic.objects.TileObject;
import en.fluffyBerserk.game.logic.objects.bullets.Bullet;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.game.logic.objects.creatures.player.Player;
import en.fluffyBerserk.game.logic.objects.items.PickableItem;
import en.fluffyBerserk.gui.utils.Collision;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Vector;

public final class GameLoop {

    @NotNull
    private final Game game;

    @NotNull
    private final AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            updateGame();
        }
    };

    public GameLoop(@NotNull Game game) {
        this.game = game;
    }

    public void start() {
        timer.start();
        Main.app.setGame(game);
        game.running = true;
        System.out.println("Game loop started");
    }

    public void stop(){
        timer.stop();
    }

    private void updateGame() {
        Canvas gameCanvas = game.getGameGraphics().getCanvas();

        // Clear the whole canvas
        gameCanvas.getGraphicsContext2D().clearRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());

        drawMap(gameCanvas);

        drawTiles(gameCanvas);

        drawObjects(gameCanvas);

        removeUnnecessaryEntities();

        drawEntities(gameCanvas);

        game.getPlayer().reduceCooldown();
    }

    private void drawMap(Canvas canvas) {
        Image mapImage = new Image(game.getCurrentMap().getImagePath());
        canvas.getGraphicsContext2D().drawImage(
                mapImage,
                game.getCamera().processX(0),
                game.getCamera().processY(0),
                game.getCurrentMap().getWidth(),
                game.getCurrentMap().getHeight()
        );
    }

    private void drawTiles(Canvas canvas) {
        Vector<Vector<TileObject>> tiles = game.getCurrentMap().getTiles();

        for (Vector<TileObject> tileObjects : tiles) {
            for (TileObject tile : tileObjects) {
                if (tile == null) { // blank tile
                    continue;
                }

                canvas.getGraphicsContext2D().drawImage(
                        tile.getImage(),
                        game.getCamera().processX(tile.getX()),
                        game.getCamera().processY(tile.getY()),
                        tile.getWidth(),
                        tile.getHeight()
                );

                if (Constants.SHOW_HIT_BOX) {
                    canvas.getGraphicsContext2D().strokeRect(
                            game.getCamera().processX(tile.getX()),
                            game.getCamera().processY(tile.getY()),
                            tile.getWidth(),
                            tile.getHeight()
                    );
                }
            }
        }
    }

    private void drawObjects(Canvas canvas) {
        Entity[] objects = game.getCurrentMap().getObjects();

        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] != null) {
                    canvas.getGraphicsContext2D().drawImage(
                            objects[i].getImage(),
                            game.getCamera().processX(objects[i].getX()),
                            game.getCamera().processY(objects[i].getY()),
                            objects[i].getWidth(),
                            objects[i].getHeight()
                    );
                    if (objects[i] instanceof Animated) {
                        ((Animated) objects[i]).getAnimationManager().increaseTick();
                    }


                    if (Constants.SHOW_HIT_BOX) {
                        canvas.getGraphicsContext2D().strokeRect(
                                game.getCamera().processX(objects[i].getHitBoxX()),
                                game.getCamera().processY(objects[i].getHitBoxY()),
                                objects[i].getHitBoxWidth(),
                                objects[i].getHitBoxHeight()
                        );
                    }
                }
            }
        }

    }

    private void drawEntities(Canvas canvas) {
        ArrayList<Entity> itemsToRemoveFromMap = new ArrayList<>();

        for (Entity entity : game.getEntityManager().getEntities()) {
            if (!(entity instanceof MovableEntity)) {
                continue;
            }

            for (Entity entity1 : game.getEntityManager().getEntities())
                if (entity1 instanceof PickableItem && entity instanceof Player && Collision.objectsCollide(entity,entity1)){
                    game.getInventory().addItem((PickableItem) entity1);
                    itemsToRemoveFromMap.add(entity1);
                    System.out.println("Item picked");
                    break;
                }

            ((MovableEntity) entity).move();
            if (entity instanceof Animated) {
                ((Animated) entity).getAnimationManager().increaseTick();
            }

            //reduce lifeSpan of a used bullet
            if (entity instanceof Bullet && ((Bullet) entity).bulletDmg <= 0) {
                ((Bullet) entity).reduceLifeSpan();
            }

            // Don't check collision for bullets X tiles or objects (structures)
            if (!(entity.getType().equals(ObjectType.BULLET_PLAYER))) {

                // Check collision with tiles
                Vector<Vector<TileObject>> tiles = game.getCurrentMap().getTiles();
                outerFor:
                for (Vector<TileObject> tileObjects : tiles) {
                    for (TileObject tile : tileObjects) {
                        if (tile == null) { // blank tile
                            continue;
                        }

                        if (Collision.objectsCollide(tile, entity)) {
                            entity.setX(entity.getPreviousX());
                            entity.setY(entity.getPreviousY());
                            entity.setHitBoxX(entity.getPreviousHitBoxX());
                            entity.setHitBoxY(entity.getPreviousHitBoxY());
                            break outerFor;
                        }
                    }
                }

                // Check collision with objects
                Entity[] objects = game.getCurrentMap().getObjects();
                outerFor:
                if (objects != null) {
                    for (int i = 0; i < objects.length; i++) {
                        if (objects[i] == null) {
                            continue;
                        }

                        if (Collision.objectsCollide(objects[i], entity)) {
                            entity.setX(entity.getPreviousX());
                            entity.setY(entity.getPreviousY());
                            entity.setHitBoxX(entity.getPreviousHitBoxX());
                            entity.setHitBoxY(entity.getPreviousHitBoxY());

                            if (objects[i].getType().equals(ObjectType.HOME)) {
                                game.playerSpawner.spawnOnMap(2);
                                if (game.map2 == null){
                                    game.map2 = new Map2();
                                    game.setCurrentMap(game.map2);
                                    System.out.println("new map");
                                } else {
                                    game.setCurrentMap(game.map2);
                                    System.out.println("old map");
                                }

                            }
                            if (objects[i].getType().equals(ObjectType.CARPET)) {
                                game.playerSpawner.spawnOnMap(1);
                                game.setCurrentMap(new Map1());
                            }
                            break outerFor;
                        }
                    }
                }
            }
        }

        if (itemsToRemoveFromMap.size() == 1){
            game.getEntityManager().removeEntity(itemsToRemoveFromMap.get(0));
            itemsToRemoveFromMap.clear();
        }


        // Check collision with other entities (bullets, monsters, npc, items etc.)
        for (Entity entity1 : game.getEntityManager().getEntities()){
            if (entity1.getType().equals(ObjectType.BULLET_PLAYER))
            for (Entity  entity2 : game.getEntityManager().getEntities()){
                if (entity2.getType().equals(ObjectType.ENEMY)) {
                    if (Collision.objectsCollide(entity1, entity2)){
                        ((Creature) entity2).damaged(((Bullet) entity1).getDmg());
                        ((Bullet) entity1).setDmg(0);
                    }
                }
            }
        }


        // This will render all entities on the map (npcs, bullets, player, items, chests, portals etc.)
        for (Entity entity : game.getEntityManager().getEntities()) {
            canvas.getGraphicsContext2D().drawImage(
                    entity.getImage(),
                    game.getCamera().processX(entity.getX()),
                    game.getCamera().processY(entity.getY()),
                    entity.getWidth(),
                    entity.getHeight()
            );

            if (Constants.SHOW_HIT_BOX) {
                canvas.getGraphicsContext2D().strokeRect(
                        game.getCamera().processX(entity.getHitBoxX()),
                        game.getCamera().processY(entity.getHitBoxY()),
                        entity.getHitBoxWidth(),
                        entity.getHitBoxHeight()
                );
            }
        }
    }

    private void removeUnnecessaryEntities() {
        for (Entity entity : game.getEntityManager().getEntities()) {

            //Delete entities that are further than total visible space
            if (entity.getX() < -Constants.SCREEN_WIDTH / 2
                    || entity.getX() > game.getCurrentMap().getWidth() + Constants.SCREEN_WIDTH / 2
                    || entity.getY() < -Constants.SCREEN_HEIGHT / 2
                    || entity.getY() > game.getCurrentMap().getHeight() + Constants.SCREEN_HEIGHT / 2) {
                game.getEntityManager().removeEntity(entity);
            }

            //Delete Hostile entities, who have less than 0 hp;
            if (entity.getType().equals(ObjectType.ENEMY) && ((Creature) entity).getHp() <= 0) {
                game.getEntityManager().removeEntity(entity);
            }

            //Delete bullets which lifeSpan is below 0
            if((entity.getType().equals(ObjectType.BULLET_PLAYER) || entity.getType().equals(ObjectType.BULLET_HOSTILE))
            && ((Bullet) entity).lifeSpan <= 0) {
                game.getEntityManager().getEntities().remove(entity);
            }
        }
    }
}
