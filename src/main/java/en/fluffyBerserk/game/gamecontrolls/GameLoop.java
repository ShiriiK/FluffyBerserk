package en.fluffyBerserk.game.gamecontrolls;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.logic.Animated;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.maps.Map1;
import en.fluffyBerserk.game.logic.maps.Map2;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.MovableEntity;
import en.fluffyBerserk.game.logic.objects.TileObject;
import en.fluffyBerserk.game.logic.objects.bullets.Bullet;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.game.logic.objects.creatures.npc.MeleeNpc;
import en.fluffyBerserk.game.logic.objects.creatures.npc.Npc;
import en.fluffyBerserk.game.logic.objects.creatures.npc.RangedNpc;
import en.fluffyBerserk.game.logic.objects.creatures.npc.npcs.Boss;
import en.fluffyBerserk.game.logic.objects.creatures.npc.npcs.Death;
import en.fluffyBerserk.game.logic.objects.creatures.player.Player;
import en.fluffyBerserk.game.logic.objects.items.potions.HealthPotion;
import en.fluffyBerserk.game.logic.objects.items.potions.Potion;
import en.fluffyBerserk.game.logic.objects.items.potions.StaminaPotion;
import en.fluffyBerserk.game.logic.objects.items.potions.StrengthPotion;
import en.fluffyBerserk.gui.popups.PopUpMenu;
import en.fluffyBerserk.gui.utils.Collision;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Vector;

public final class GameLoop {

    @NotNull private final Game game;
    private Death death;
    private Potion potion;
    private double staminaSpan = 1;
    private double strengthSpan = 1;

    public AnimationTimer staminaPotionTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            staminaPotion();
        }
    };

    public AnimationTimer stengthPotionTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            strengthPotion();
        }
    };

    @NotNull private final AnimationTimer timer = new AnimationTimer() {
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
        removeAllBullets();
        System.out.println("Game loop started");
    }

    public void stop() {
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

        drawHpHud(gameCanvas);

        game.getPlayer().reduceCooldown();

        checkPlayerDead();
    }


    private void drawHpHud(Canvas gameCanvas) {
        gameCanvas.getGraphicsContext2D().setFill(Color.RED);
        gameCanvas.getGraphicsContext2D().setFont(new Font(30));
        gameCanvas.getGraphicsContext2D().fillText("HP: " + game.getPlayer().getHp() + "\nCooldown: " + (game.getPlayer().getAttackCd()-50), Constants.SCREEN_WIDTH-200, Constants.SCREEN_HEIGHT-100);
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

        for (Entity entity : game.getEntityManager().getEntities()) {
            if (!(entity instanceof MovableEntity)) { continue; }
            this.checkEntityMove(entity);
            this.checkEntityMechanics(entity);
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
            // Add health bar for Enemies
            if (entity instanceof Npc){
                canvas.getGraphicsContext2D().fillRect(
                        game.getCamera().processX(entity.getHitBoxX()),
                        game.getCamera().processY(entity.getHitBoxY() - 5),
                        (float) (entity.getHitBoxWidth() * ((Npc) entity).getHp() / ((Npc) entity).getMaxHp()),
                        5
                );
                canvas.getGraphicsContext2D().strokeRect(
                        game.getCamera().processX(entity.getHitBoxX()),
                        game.getCamera().processY(entity.getHitBoxY() - 5),
                        entity.getHitBoxWidth(),
                        5
                );
            }
        }
    }



    private void checkPlayerDead() {
        if (game.getPlayer().isDead()) {
            removeAllBullets();
            Main.app.showPopUp(new PopUpMenu());
            game.getPlayer().setMoveY(0F);
            game.getPlayer().setMoveX(0F);
            game.getGameLoop().stop();
            System.out.println("Game loop stopped");
        }
    }

    // Checks for Entity mechanics such as cooldowns, health change or bullet collisions
    private void checkEntityMechanics(Entity entity) {

        //Player picks up Potion
        for (Entity entity1 : game.getEntityManager().getEntities()) {
            if (entity1 instanceof Potion && entity instanceof Player && Collision.objectsCollide(entity, entity1)) {
                game.getInventory().addItem((Potion) entity1);
                game.getEntityManager().removeEntity(entity1);
                System.out.println("Item picked");
                break;
            }
        }

        // Check if RangedNPC can shoot
        if (entity instanceof RangedNpc) {
            ((RangedNpc) entity).shoot();
        }

        // Melee attackCd calculation
        if (entity instanceof MeleeNpc) {
            ((MeleeNpc) entity).refreshCd();
        }

        // Reduce used Bullet lifespan for visual
        if (entity instanceof Bullet && ((Bullet) entity).bulletDmg <= 0) {
            ((Bullet) entity).reduceLifeSpan();
        }

        // Reduce Death lifespan for visual
        if (entity instanceof Death) {
            entity.setY(entity.getY() - 2);
            ((Death) entity).reduceLifeSpan();
        }

        // Player Bullet X Enemy
        if (entity.getType().equals(ObjectType.BULLET_PLAYER)) {
            for (Entity entity2 : game.getEntityManager().getEntities()) {
                if (entity2.getType().equals(ObjectType.ENEMY) && Collision.objectsCollide(entity, entity2)) {
                    ((Creature) entity2).damaged(((Bullet) entity).getDmg());
                    ((Bullet) entity).setDmg(0);
                }
            }
        }

        // Enemy Bullet x Player
        if (entity.getType().equals(ObjectType.BULLET_ENEMY)) {
            for (Entity entity2 : game.getEntityManager().getEntities()) {
                if (entity2.getType().equals(ObjectType.PLAYER) && Collision.objectsCollide(entity, entity2)) {
                    ((Player) entity2).damaged(((Bullet) entity).getDmg());
                    System.out.println("You have got: " + ((Bullet) entity).getDmg() + " dmg");
                    ((Bullet) entity).setDmg(0);
                }
            }
        }

        // Check if MeleeNPC can damage x Player
        if (entity instanceof MeleeNpc) {
            for (Entity entity1 : game.getEntityManager().getEntities()) {
                if (entity1.getType().equals(ObjectType.PLAYER) && Collision.objectsCollide(entity, entity1) && ((MeleeNpc) entity).canAttack()) {
                    ((MeleeNpc) entity).resetCd();
                    ((Player) entity1).damaged(((Creature) entity).getDmg());
                    System.out.println("You have got: " + ((Creature) entity).getDmg() + " dmg");
                }
            }
        }
    }

    // Checks for Entity movement and position
    private void checkEntityMove(Entity entity) {
        ((MovableEntity) entity).move();

        if (entity instanceof Animated) {
            ((Animated) entity).getAnimationManager().increaseTick();
        }

        // Don't check Bullet collision with Tiles and Objects (Structures)
        if (!(entity instanceof Bullet)) {
            // Check collision with tiles
            Vector<Vector<TileObject>> tiles = game.getCurrentMap().getTiles();
            outerFor:
            for (Vector<TileObject> tileObjects : tiles) {
                for (TileObject tile : tileObjects) {
                    if (tile == null) { continue; }

                    if (Collision.objectsCollide(tile, entity)) {
                        returnEntityPosition(entity);
                        break outerFor;
                    }
                }
            }

            // Check collision with objects
            Entity[] objects = game.getCurrentMap().getObjects();
            outerFor:
            if (objects != null) {
                for (int i = 0; i < objects.length; i++) {
                    if (objects[i] == null) { continue; }

                    if (Collision.objectsCollide(objects[i], entity)) {
                        returnEntityPosition(entity);

                        if (objects[i].getType().equals(ObjectType.HOME)) {
                            teleportToHome();
                        }
                        if (objects[i].getType().equals(ObjectType.CARPET)) {
                            teleportFromHome();
                        }
                        break outerFor;
                    }
                }
            }

            for (Entity entity1 : game.getEntityManager().getEntities()) {
                if (!entity.equals(entity1) && entity1 instanceof Npc && entity instanceof Npc &&
                        Collision.objectsCollide(entity1, entity)) {
                    returnEntityPosition(entity);
                }
            }
        }
    }



    private void returnEntityPosition(Entity entity) {
        entity.setX(entity.getPreviousX());
        entity.setY(entity.getPreviousY());
        entity.setHitBoxX(entity.getPreviousHitBoxX());
        entity.setHitBoxY(entity.getPreviousHitBoxY());
    }

    private void removeAllBullets() {
        for (Entity entity : game.getEntityManager().getEntities()) {
            if (entity.getType().equals(ObjectType.BULLET_PLAYER) || entity.getType().equals(ObjectType.BULLET_ENEMY)) {
                game.getEntityManager().removeEntity(entity);
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
                death = new Death();
                death.setX(entity.getX());
                death.setY(entity.getY());
                game.getEntityManager().addEntity(death);

                if(entity instanceof Boss){
                    game.setPhase(game.getPhase() + 1);
                }

                Random random = new Random();
                if (Constants.DROP_RATE >= random.nextInt(100)) {
                    Random random1 = new Random();
                    int i = random1.nextInt(Constants.NUMBER_OF_POTIONS);
                    if (i == 1) {
                        potion = new StaminaPotion();
                    } else if (i == 2) {
                        potion = new HealthPotion();
                    } else if (i == 3) {
                        potion = new StrengthPotion();
                    }
                    potion.setX(entity.getX());
                    potion.setY(entity.getY());

                    game.getEntityManager().addEntity(potion);
                    game.getCurrentMap().getEntities().add(potion);
                }

                game.getEntityManager().removeEntity(entity);
                game.getCurrentMap().getEntities().remove(entity);
            }

            //Delete bullets which lifeSpan is below 0
            if ((entity.getType().equals(ObjectType.BULLET_PLAYER) || entity.getType().equals(ObjectType.BULLET_ENEMY))
                    && ((Bullet) entity).lifeSpan <= 0) {
                game.getEntityManager().getEntities().remove(entity);
            }

            //Delete DeathAngels which lifeSpan is below 0
            if (entity instanceof Death
                    && ((Death) entity).lifeSpan <= 0) {
                game.getEntityManager().getEntities().remove(entity);
            }
        }
    }



    private void staminaPotion() {
        staminaSpan -= 0.001;
        System.out.println("cd =" + game.getPlayer().getMaxCd());
        if (staminaSpan <= 0) {
            game.getPlayer().setMaxCd(50);
            staminaSpan = 1;
            staminaPotionTimer.stop();
            System.out.println("timer stopped, cd = " + game.getPlayer().getMaxCd());
        }
    }

    private void strengthPotion() {
        strengthSpan -= 0.001;
        if (strengthSpan <= 0) {
            game.getPlayer().getCharacter().setStrength(-10);
            strengthSpan = 1;
            staminaPotionTimer.stop();
            System.out.println("timer stopped");
        }
    }

    private void teleportFromHome() {
        game.playerSpawner.spawnOnMap(1);
        game.setCurrentMap(new Map1());
    }

    private void teleportToHome() {
        game.playerSpawner.spawnOnMap(2);
        if (game.map2 == null) {
            game.map2 = new Map2();
        }
        game.setCurrentMap(game.map2);
    }






}
