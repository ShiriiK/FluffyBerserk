package en.fluffyBerserk.game.gamecontrolls;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.maps.Home;
import en.fluffyBerserk.game.logic.maps.SafeZoneMap;
import en.fluffyBerserk.game.logic.objects.AnimatedEntity;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.MovableEntity;
import en.fluffyBerserk.game.logic.objects.TileObject;
import en.fluffyBerserk.gui.popups.PopUpPortal;
import en.fluffyBerserk.gui.utils.Collision;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.util.Vector;

public final class GameLoop {

    @NotNull
    private final Game game;
    private PopUpPortal portal;
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
    }

    private void updateGame() {
        Canvas gameCanvas = game.getGameGraphics().getCanvas();

        // Clear the whole canvas
        gameCanvas.getGraphicsContext2D().clearRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());

        drawMap(gameCanvas);

        drawTiles(gameCanvas);

        drawObjects(gameCanvas);

        drawEntities(gameCanvas);
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
                    if(objects[i] instanceof AnimatedEntity){
                        ((AnimatedEntity) objects[i]).getAnimationManager().increaseTick();
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
        for (Entity entity : game.getEntityManager().getEntities()) {
            if (!(entity instanceof MovableEntity)) {
                continue;
            }

            ((MovableEntity) entity).move();

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

                        if (objects[i].getType().equals(ObjectType.PORTAL)) {
                            portal = new PopUpPortal(game);
                            game.getPlayer().setMoveY(0F);
                            game.getPlayer().setMoveX(0F);
                            Main.app.showPopUp(portal);
                        }
                        if (objects[i].getType().equals(ObjectType.HOME)){
                            game.setCurrentMap(new Home());
                            game.getPlayer().setX((float) (Constants.TILE_SIZE*4.5));
                            game.getPlayer().setY(Constants.TILE_SIZE*7);
                            game.getPlayer().setHitBoxX(game.getPlayer().getX()+20);
                            game.getPlayer().setHitBoxY(game.getPlayer().getY()+30);

                        }
                        if (objects[i].getType().equals(ObjectType.CARPET)){
                            game.setCurrentMap(new SafeZoneMap());
                            game.getPlayer().setX((float) (Constants.TILE_SIZE*5.5));
                            game.getPlayer().setY((float) (Constants.TILE_SIZE*2.5));
                            game.getPlayer().setHitBoxX(game.getPlayer().getX()+20);
                            game.getPlayer().setHitBoxY(game.getPlayer().getY()+30);
                        }
                        break outerFor;
                    }
                }
            }
        }

        // Check collision with other entities (bullets, monsters, npc, items etc.)

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
}
