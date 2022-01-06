package en.fluffyBerserk.gui.utils;

import javafx.scene.image.Image;

/**
 * Image that remembers its path and also has unique index
 */
public class LocateImage extends Image {
    private final String path;
    private final int index;

    public LocateImage(String p, int i) {
        super(p);
        this.path = p;
        this.index = i;
    }

    public String getPath() {
        return path;
    }

    public int getIndex() {
        return index;
    }
}
