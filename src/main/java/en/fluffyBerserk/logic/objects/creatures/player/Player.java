package en.fluffyBerserk.logic.objects.creatures.player;

import en.fluffyBerserk.gui.animations.MovableEntityAnimations;
import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.invariables.Direction;
import en.fluffyBerserk.invariables.Sprites;
import en.fluffyBerserk.logic.objects.creatures.CanAttack;
import en.fluffyBerserk.logic.objects.creatures.CanDie;
import en.fluffyBerserk.logic.objects.creatures.CanShoot;
import en.fluffyBerserk.logic.objects.creatures.Creature;
import javafx.scene.image.Image;
import java.util.ArrayList;


/**
 * Class representing players.
 */
public class Player extends Creature implements CanShoot, CanAttack, CanDie{

    private String playerName;
    private ArrayList<Image> currentSprite;
    private boolean isAlive;
    private MovableEntityAnimations playerAnimations;
    private String direction;

    // Constructor
    public Player(){

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

        playerAnimations = new MovableEntityAnimations(Sprites.fluf1);
    }

    // Changes sprite, which player animations are taken from (fluf1, fluf2, fluf3,...)
    private void changeAnimationsSprite(LocateImage image){
        playerAnimations = new MovableEntityAnimations(image);
    }

    // Sets current animation sprite (moveDown, moveUp, moveLeft, moveRight, idle)
    private void setCurrentSprite(ArrayList<Image> sprite){
        if (sprite != null){
            currentSprite = sprite;
        } else {
            System.out.println("Missing sprite!");
        }
    }

    public MovableEntityAnimations getPlayerAnimations() {
        return playerAnimations;
    }

    @Override
    public void move(int steps, Direction direction) {
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
