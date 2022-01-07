package en.fluffyBerserk.gui.utils;

import javafx.scene.Scene;

public class AttachCSS {

    /**
     * Just makes it easier to attach css to all of those scenes
     */
    public static void attachCSS(Scene scene) {
        scene.getStylesheets().add("fluf.css");
    }
}
