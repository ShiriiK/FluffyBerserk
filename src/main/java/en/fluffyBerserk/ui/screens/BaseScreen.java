package en.fluffyBerserk.ui.screens;

import javafx.scene.Scene;

/**
 * This class serves as an abstract base class for
 * all screens
 */
public abstract class BaseScreen implements Screen {

    protected final Scene scene;

    public BaseScreen() {
        scene = buildScene();
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    protected abstract Scene buildScene();
}
