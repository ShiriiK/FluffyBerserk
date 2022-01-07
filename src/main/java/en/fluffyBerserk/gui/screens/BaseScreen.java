package en.fluffyBerserk.gui.screens;

import javafx.scene.Scene;

/**
 * This class serves as an abstract base class for all screens
 */
public abstract class BaseScreen implements Screen {

    protected final Scene scene;

    // Structure of BaseScreen
    public BaseScreen() {
        // Defines scene
        scene = buildScene();
    }

    @Override
    public Scene getScene() {
        return buildScene();
    }

    @Override
    public void onEnter() {
        //
    }

    @Override
    public void onLeave() {
        //
    }

    // Abstract methods used in classes extending this class
    protected abstract Scene buildScene();
}
