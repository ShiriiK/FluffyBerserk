package en.fluffyBerserk.gui.utils;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class ImageBuilder {

    /**
     * Crops image from given sprite image that has to be LocateImage
     * cus for some reason it doesn't with normal image
     * soo it uses LocateImage, that remembers it path and uses that for recreating it
     *
     * @param image  sprite image which final image is taken from
     * @param x      x coordinate on sprite image
     * @param y      y coordinate on sprite image
     * @param width  requested width of final image
     * @param height requested height of final image
     * @return cropped image
     */
    public static Image crop(LocateImage image, int x, int y, int width, int height) {
        Image newImage = new Image(image.getPath());
        PixelReader reader = newImage.getPixelReader();
        return new WritableImage(reader, x, y, width, height);
    }
}
