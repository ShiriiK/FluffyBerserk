package en.fluffyBerserk.gui.utils;

import javafx.scene.image.Image;

public class LocateImage extends Image {
    private final String path;

    public LocateImage(String path) {
        super(path);
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
