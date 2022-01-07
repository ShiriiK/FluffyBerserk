package en.fluffyBerserk.logic.objects.creatures.player;

import en.fluffyBerserk.gui.animations.MovableEntityAnimations;
import en.fluffyBerserk.gui.animations.SpriteImage;
import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.gui.animations.SpritesFactory;
import en.fluffyBerserk.logic.objects.creatures.CanAttack;
import en.fluffyBerserk.logic.objects.creatures.CanDie;
import en.fluffyBerserk.logic.objects.creatures.CanShoot;
import en.fluffyBerserk.logic.objects.creatures.Creature;


/**
 * Class representing players.
 */
public class Player extends Creature implements CanShoot, CanAttack, CanDie{

    private static MovableEntityAnimations playerAnimations;
    public static SpriteImage currentSkin;
    private String playerName;
    private boolean isAlive;

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

        playerAnimations = new MovableEntityAnimations(SpritesFactory.getImages()[0]);
        currentSkin = new SpriteImage(playerAnimations.getUsedSprite(), 32, 0, 32, 32);
    }

    /**
     *  Changes sprite, which player animations are taken from (fluf1, fluf2, fluf3,...)
     *  as well as currentSkin
      */
    public static void changeAnimationsSprite(LocateImage image){
        playerAnimations = new MovableEntityAnimations(image);
        currentSkin = new SpriteImage(image, 32, 0, 32, 32);
    }

    public static MovableEntityAnimations getPlayerAnimations() {
        return playerAnimations;
    }

    public static SpriteImage getCurrentSkin() {
        return currentSkin;
    }

    @Override
    public void move(int steps) {
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
