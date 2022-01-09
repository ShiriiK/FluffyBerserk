package en.fluffyBerserk.logic.objects.creatures.player;

import en.fluffyBerserk.gamecontrol.KeyManager;
import en.fluffyBerserk.gui.animations.MovableEntityAnimations;
import en.fluffyBerserk.gui.animations.SpritesFactory;
import en.fluffyBerserk.gui.tile.TileManager;
import en.fluffyBerserk.gui.utils.GameCamera;
import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.invariables.Constant;
import en.fluffyBerserk.invariables.Direction;
import en.fluffyBerserk.logic.objects.creatures.CanAttack;
import en.fluffyBerserk.logic.objects.creatures.CanDie;
import en.fluffyBerserk.logic.objects.creatures.CanShoot;
import en.fluffyBerserk.logic.objects.creatures.Creature;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.io.IOException;


/**
 * Class representing players.
 */
public class Player extends Creature implements CanShoot, CanAttack, CanDie {

    public static final int screenY = (Constant.SCREEN_HEIGHT / 2 - (Constant.TILE_SIZE / 2));
    public static int screenX = (Constant.SCREEN_WIDTH / 2 - (Constant.TILE_SIZE / 2));

    private static MovableEntityAnimations playerAnimations;
    public int counter;
    public int imgNumber;

    public Direction direction;
    public Rectangle screenHitBox = new Rectangle();
    public Rectangle hitBox = new Rectangle();
    public boolean collisionOn = false;
    public int speed;

    private String playerName;

    // Constructor
    public Player() {
        setWorldX(Constant.WORLD_WIDTH / 2);
        setWorldY(Constant.WORLD_HEIGHT / 2);

        setHp(100);
        setStr(20);

        init();
    }

    private void init() {
        playerAnimations = new MovableEntityAnimations(SpritesFactory.getImages()[0]);
        counter = 0;
        imgNumber = 1;

        direction = Direction.DOWN;

        hitBox.setX((int) (getWorldX() + Constant.TILE_SIZE / 10 * 4));
        hitBox.setY((int) (getWorldY() + Constant.TILE_SIZE / 2));
        hitBox.setWidth(Constant.TILE_SIZE / 10 * 3);
        hitBox.setHeight(Constant.TILE_SIZE / 3);

        // screenHitBox is drawn on screen for better understanding how to make it better
        screenHitBox.setX(screenX + Constant.TILE_SIZE / 10 * 4);
        screenHitBox.setY(screenY + Constant.TILE_SIZE / 2);
        screenHitBox.setWidth(Constant.TILE_SIZE / 10 * 3);
        screenHitBox.setHeight(Constant.TILE_SIZE / 3);

        speed = 6;
    }

    /**
     * Method for changing player global coordinates
     *
     * @param dx how many pixels on x-axis will be added to players global position
     * @param dy how many pixels on y-axis will be added to players global position
     */
    public void move(int dx, int dy) throws IOException {
        // Firstly ensuring that player is not trying to step outside of map boundaries
        if (getWorldX() < Constant.TILE_SIZE / 2 && dx < 0) {
            dx = 0;
        }
        if (getWorldX() >= Constant.WORLD_WIDTH - Constant.TILE_SIZE / 2 && dx > 0) {
            dx = 0;
        }
        if (getWorldY() < Constant.TILE_SIZE / 2 && dy < 0) {
            dy = 0;
        }
        if (getWorldY() >= Constant.WORLD_HEIGHT - Constant.TILE_SIZE / 4 * 3 && dy > 0) {
            dy = 0;
        }

        // Do not continue if there will be no changes in coordinates
        if (dx == 0 && dy == 0) {
            return;
        }

        // Checking for collision detection and if there is none that allow to change
        // players global coordinates as well as the hit-box coordinates
        collisionOn = false;
        checkCollision();
        if (!collisionOn) {
            setWorldX(getWorldX() + dx);
            setWorldY(getWorldY() + dy);
            hitBox.setX((int) getWorldX() + Constant.TILE_SIZE / 10 * 4);
            hitBox.setY((int) getWorldY() + Constant.TILE_SIZE / 2);
        }

    }

    /**
     * Method for checking players collision hit-box with tiles on map
     * Currently not working very well
     */
    private void checkCollision() throws IOException {
        TileManager tileManager = new TileManager();

        int topLeft = (int) hitBox.getX();
        int topRight = (int) (hitBox.getX() + hitBox.getWidth());
        int topWorldY = (int) hitBox.getY();
        int bottomWorldY = (int) (hitBox.getY() + hitBox.getHeight());

        int leftCol = topLeft / Constant.TILE_SIZE;
        int rightCol = topRight / Constant.TILE_SIZE;
        int topRow = topWorldY / Constant.TILE_SIZE;
        int bottomRow = bottomWorldY / Constant.TILE_SIZE;

        int tileNum1, tileNum2;
        switch (direction) {
            case UP:
                topRow = (int) ((topWorldY - speed - hitBox.getHeight()) / Constant.TILE_SIZE);
                tileNum1 = tileManager.tileNumber[leftCol][topRow];
                tileNum2 = tileManager.tileNumber[rightCol][topRow];
                if (tileManager.tile[tileNum1].collision || tileManager.tile[tileNum2].collision) {
                    collisionOn = true;
                }
                break;
            case DOWN:
                bottomRow = (int) ((bottomWorldY + speed + hitBox.getHeight()) / Constant.TILE_SIZE);
                tileNum1 = tileManager.tileNumber[leftCol][bottomRow];
                tileNum2 = tileManager.tileNumber[rightCol][bottomRow];
                if (tileManager.tile[tileNum1].collision || tileManager.tile[tileNum2].collision) {
                    collisionOn = true;
                }
                break;
            case LEFT:
                leftCol = (int) ((topLeft - speed - hitBox.getWidth()) / Constant.TILE_SIZE);
                tileNum1 = tileManager.tileNumber[leftCol][topRow];
                tileNum2 = tileManager.tileNumber[leftCol][bottomRow];
                if (tileManager.tile[tileNum1].collision || tileManager.tile[tileNum2].collision) {
                    collisionOn = true;
                }
                break;
            case RIGHT:
                rightCol = (int) ((topLeft + speed + hitBox.getWidth()) / Constant.TILE_SIZE);
                tileNum1 = tileManager.tileNumber[rightCol][topRow];
                tileNum2 = tileManager.tileNumber[rightCol][bottomRow];
                if (tileManager.tile[tileNum1].collision || tileManager.tile[tileNum2].collision) {
                    collisionOn = true;
                }
                break;
        }
    }

    /**
     * Method for rendering player on screen
     * and doing the animation magic using imgNumber and counter
     * values of imgNumber and counter are managed in players animation timer
     * player will be always rendered in the center of the screen
     *
     * @param graphicsContext used for drawing players image on canvas
     * @param gameCamera      used for actually centering player on the screen
     */
    public void renderPlayer(GraphicsContext graphicsContext, GameCamera gameCamera) {
        Image image = playerAnimations.getMoveDown().get(1);
        if (KeyManager.UP) {
            if (imgNumber == 1) {
                image = playerAnimations.getMoveUp().get(0);
            }
            if (imgNumber == 2) {
                image = playerAnimations.getMoveUp().get(1);
            }
            if (imgNumber == 3) {
                image = playerAnimations.getMoveUp().get(2);
            }
        }
        if (KeyManager.DOWN) {
            if (imgNumber == 1) {
                image = playerAnimations.getMoveDown().get(0);
            }
            if (imgNumber == 2) {
                image = playerAnimations.getMoveDown().get(1);
            }
            if (imgNumber == 3) {
                image = playerAnimations.getMoveDown().get(2);
            }
        }
        if (KeyManager.LEFT) {
            if (imgNumber == 1) {
                image = playerAnimations.getMoveLeft().get(0);
            }
            if (imgNumber == 2) {
                image = playerAnimations.getMoveLeft().get(1);
            }
            if (imgNumber == 3) {
                image = playerAnimations.getMoveLeft().get(2);
            }
        }
        if (KeyManager.RIGHT) {
            if (imgNumber == 1) {
                image = playerAnimations.getMoveRight().get(0);
            }
            if (imgNumber == 2) {
                image = playerAnimations.getMoveRight().get(1);
            }
            if (imgNumber == 3) {
                image = playerAnimations.getMoveRight().get(2);
            }
        }

        int x = Player.screenX;
        int y = Player.screenY;

        graphicsContext.clearRect(0, 0, Constant.SCREEN_WIDTH, Constant.SCREEN_HEIGHT);
        graphicsContext.drawImage(image, x, y, Constant.TILE_SIZE, Constant.TILE_SIZE);
        gameCamera.centrOnEntity(this);
    }

    /**
     * Changes sprite, which player animations are taken from (fluf1, fluf2, fluf3,...)
     */
    public static void changeAnimationsSprite(LocateImage image) {
        playerAnimations = new MovableEntityAnimations(image);
    }

    public static MovableEntityAnimations getPlayerAnimations() {
        return playerAnimations;
    }

    @Override
    public String getImagePath() {
        return null;
    }

    @Override
    public String getName() {
        return playerName; // TODO players name
    }

    @Override
    public void attack(Creature creature) {
        // TODO
    }

    @Override
    public void shoot() {

    }

    @Override
    public void die() {

    }

    @Override
    public int looseHP(int dmg) {
        return 0;
    }
}
