package en.fluffyBerserk.gui.animations;

import en.fluffyBerserk.gui.utils.ImageBuilder;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

public class Sprite {

    private final Image frame;

    //Moving entity
    public Sprite(Object objectReference, int spriteLocationX, int spriteLocationY, int width, int height, LocateImage sprite){
        frame = ImageBuilder.crop(sprite, spriteLocationX, spriteLocationY, width, height);
    }

    public Image getFrame(){
        return frame;
    }
}
