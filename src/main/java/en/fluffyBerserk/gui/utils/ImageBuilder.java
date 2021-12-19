package en.fluffyBerserk.gui.utils;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import java.io.File;

public class ImageBuilder {

    public static Image loadImage(String path){
        File file = new File(path);

        //Message for console
        System.out.println("Loading: " + file.exists());

        String imagePath = file.getAbsolutePath();
        imagePath = "file: " + imagePath.replace('/', File.separatorChar);

        //Message for console
        System.out.println("Imagepath: " + imagePath);

        return new Image(imagePath);
    }

    public static Image crop(Image image, int x, int y, int width, int height){
        PixelReader reader = image.getPixelReader();
        return new WritableImage(reader, x, y, width, height);
    }
}
