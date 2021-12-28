package en.fluffyBerserk.logic.objects.creatures.player;

import en.fluffyBerserk.gui.animations.MovableEntityAnimations;
import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.gui.utils.Observer;
import en.fluffyBerserk.gui.utils.SubjectOfChange;
import en.fluffyBerserk.invariables.Direction;
import en.fluffyBerserk.invariables.Sprites;
import en.fluffyBerserk.logic.objects.creatures.CanAttack;
import en.fluffyBerserk.logic.objects.creatures.CanDie;
import en.fluffyBerserk.logic.objects.creatures.CanShoot;
import en.fluffyBerserk.logic.objects.creatures.Creature;
import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class representing players.
 */
public class Player extends Creature implements CanShoot, CanAttack, CanDie, SubjectOfChange {

    private String playerName;
    private boolean isAlive;
    private int positionX;
    private int positionY;
    private Image[] currentSprite;
    private Direction currentDirection;
    private MovableEntityAnimations playerAnimations;
    private final Set<Observer> observers = new HashSet<>();

    // Constructor
    public Player(String playerName){
        this.playerName = playerName;
        this.isAlive = true;
        setY(100);
        setX(100);
        setHp(100);
        setStr(20);
        init();
    }

    // Sets default sprite for animations and current sprite
    private void init() {
        playerAnimations = new MovableEntityAnimations(this, Sprites.fluf1);
        currentSprite = playerAnimations.getIdle();
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

    //
    @Override
    public void move(int steps, Direction direction) {
        if (steps == 0 && !Arrays.equals(currentSprite, playerAnimations.getIdle())){
            setCurrentSprite(playerAnimations.getIdle());
            notifyObservers();
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
            notifyObservers();
        }
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

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
