package en.fluffyBerserk.gui.graphics.sprites;

import en.fluffyBerserk.gui.utils.ImageBuilder;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

/**
 * Class for defining individual images from sprite image
 */
public class SpriteImage {

    private static LocateImage usedSprite;
    private final Image frame;

    /**
     * Tries to build image based on given parameters
     *
     * @param sprite  sprite image which final image is taken from
     * @param spriteX x coordinate on sprite image
     * @param spriteY y coordinate on sprite image
     * @param width   requested width of final image
     * @param height  requested height of final image
     */
    public SpriteImage(LocateImage sprite, int spriteX, int spriteY, int width, int height) {
        usedSprite = new LocateImage(sprite.getPath(), sprite.getIndex());
        frame = ImageBuilder.crop(sprite, spriteX, spriteY, width, height);
    }

    public Image getFrame() {
        return frame;
    }
    public LocateImage getSprite(){
        return usedSprite;
    }
}
