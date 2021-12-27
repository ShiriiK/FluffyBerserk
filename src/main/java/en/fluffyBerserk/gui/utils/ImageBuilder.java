package en.fluffyBerserk.gui.utils;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class ImageBuilder {

    public static Image crop(LocateImage image, int x, int y, int width, int height){
        Image newImage = new Image(image.getPath());
        PixelReader reader = newImage.getPixelReader();
        return new WritableImage(reader, x, y, width, height);
    }
}
