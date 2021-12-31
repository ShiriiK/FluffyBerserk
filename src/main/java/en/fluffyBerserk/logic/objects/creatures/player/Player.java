package en.fluffyBerserk.logic.objects.creatures.player;

import en.fluffyBerserk.base.GamePanel;
import en.fluffyBerserk.gui.animations.MovableEntityAnimations;
import en.fluffyBerserk.gui.gamecontroller.KeyPressHandler;
import en.fluffyBerserk.gui.gamecontroller.KeyReleaseHandler;
import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.invariables.Direction;
import en.fluffyBerserk.invariables.Invariables;
import en.fluffyBerserk.invariables.Sprites;
import en.fluffyBerserk.logic.objects.creatures.CanAttack;
import en.fluffyBerserk.logic.objects.creatures.CanDie;
import en.fluffyBerserk.logic.objects.creatures.CanShoot;
import en.fluffyBerserk.logic.objects.creatures.Creature;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class representing players.
 */
public class Player extends Creature implements CanShoot, CanAttack, CanDie{

    private final GamePanel gamePanel;
    private final KeyPressHandler keyPressHandler;
    private final KeyReleaseHandler keyReleaseHandler;

    private String playerName;
    private boolean isAlive;
    private int positionX;
    private int positionY;
    private Image[] currentSprite;
    private Direction currentDirection;
    private MovableEntityAnimations playerAnimations;

    // Constructor
    public Player(GamePanel gamePanel, KeyReleaseHandler keyReleaseHandler, KeyPressHandler keyPressHandler){
        this.gamePanel = gamePanel;
        this.keyReleaseHandler= keyReleaseHandler;
        this.keyPressHandler = keyPressHandler;
        this.isAlive = true;

        init();
    }

    private void init(){
        setY(100);
        setX(100);
        setHp(100);
        setStr(20);
        direction = "down";
        counter = 0;
        imgNumber = 1;

        playerAnimations = new MovableEntityAnimations(this, Sprites.fluf1);
    }

    // Changes sprite, which player animations are taken from (fluf1, fluf2, fluf3,...)
    private void changeAnimationsSprite(LocateImage image){
        playerAnimations = new MovableEntityAnimations(this, image);
    }

    // Sets current animation sprite (moveDown, moveUp, moveLeft, moveRight, idle)
    private void setCurrentSprite(Image[] sprite){
        if (sprite != null){
            currentSprite = sprite;
        } else {
            System.out.println("Missing sprite!");
        }
    }

    public void update(){
        if(keyPressHandler.UP || keyPressHandler.DOWN || keyPressHandler.LEFT || keyPressHandler.RIGHT){
            if(keyPressHandler.UP){
                direction = "up";
                y -= speed;
            }
            else if (keyPressHandler.DOWN){
                direction = "down";
                y += speed;
            }
            else if (keyPressHandler.LEFT){
                direction = "left";
                x -= speed;
            }
            else {
                direction = "right";
                x += speed;
            }

            counter++;
            if(counter > 10){ //player image changes every 10 frames
                if(imgNumber == 1){
                    imgNumber = 2;
                } else if (imgNumber == 2){
                    imgNumber = 3;
                } else if (imgNumber == 3){
                    imgNumber = 1;
                }
                counter = 0;
            }
        }

    }
    public void render(GraphicsContext graphicsContext) {
        Image image = null;
        switch (direction) {
            case "up":
                if (imgNumber == 1) {
                    image = playerAnimations.getMoveUp().get(0);
                }
                if (imgNumber == 2) {
                    image = playerAnimations.getMoveUp().get(1);
                }
                if (imgNumber == 3) {
                    image = playerAnimations.getMoveUp().get(2);
                }
                break;
            case "down":
                if (imgNumber == 1) {
                    image = playerAnimations.getMoveDown().get(0);
                }
                if (imgNumber == 2) {
                    image = playerAnimations.getMoveDown().get(1);
                }
                if (imgNumber == 3) {
                    image = playerAnimations.getMoveDown().get(2);
                }
                break;
            case "left":
                if (imgNumber == 1) {
                    image = playerAnimations.getMoveLeft().get(0);
                }
                if (imgNumber == 2) {
                    image = playerAnimations.getMoveLeft().get(1);
                }
                if (imgNumber == 3) {
                    image = playerAnimations.getMoveLeft().get(2);
                }
                break;
            case "right":
                if (imgNumber == 1) {
                    image = playerAnimations.getMoveRight().get(0);
                }
                if (imgNumber == 2) {
                    image = playerAnimations.getMoveRight().get(1);
                }
                if (imgNumber == 3) {
                    image = playerAnimations.getMoveRight().get(2);
                }
                break;
        }
        graphicsContext.drawImage(image, x, y, Invariables.TILE_SIZE, Invariables.TILE_SIZE);
    }

    @Override
    public void move(int steps, Direction direction) {
        /**
        if (steps == 0 && !Arrays.equals(currentSprite, playerAnimations.getIdle())){
            setCurrentSprite(playerAnimations.getIdle());
        } else {
            switch (direction) {
                case DOWN:
                    setCurrentSprite(playerAnimations.getMoveDown());
                    currentDirection = Direction.UP;
                    break;
                case LEFT:
                    setCurrentSprite(playerAnimations.getMoveLeft());
                    currentDirection = Direction.LEFT;
                    break;
                case RIGHT:
                    setCurrentSprite(playerAnimations.getMoveRight());
                    currentDirection = Direction.RIGHT;
                    break;
                case UP:
                    setCurrentSprite(playerAnimations.getMoveUp());
                    currentDirection = Direction.UP;
            }
        }*/
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
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
        // TODO
    }


    @Override
    public void die() {

    }

    @Override
    public int looseHP(int dmg) {
        return 0;
    }
}
