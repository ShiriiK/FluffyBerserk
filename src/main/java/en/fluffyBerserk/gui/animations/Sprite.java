package en.fluffyBerserk.gui.animations;

import en.fluffyBerserk.gui.utils.ImageBuilder;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

public class Sprite {

    private Object objectReference;
    private int spriteLocationX, spriteLocationY, numberOfFrames, width, height;
    private double speed;
    private boolean moving;
    private Image frame;
    private LocateImage sprite;
    private Image[] frames;

    //Moving entity
    public Sprite(Object objectReference, int spriteLocationX, int spriteLocationY, int width, int height, LocateImage sprite){
        this.objectReference = objectReference;
        this.spriteLocationX = spriteLocationX;
        this.spriteLocationY = spriteLocationY;
        this.width = width;
        this.height = height;
        frame = ImageBuilder.crop(sprite, spriteLocationX, spriteLocationY, width, height);
    }

    public Image getFrame(){
        return frame;
    }
}