package en.fluffyBerserk.gui.screens;
import javafx.scene.Scene;

/**
 * This class serves as an abstract base class for all screens
 */
public abstract class Screen {

    public Scene getScene() {
        return buildScene();
    }

    // Abstract methods used in classes extending this class
    protected abstract Scene buildScene();

    public abstract void onEnter();

    public abstract void onLeave();
}
