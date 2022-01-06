package en.fluffyBerserk.gui.screens;

import javafx.scene.Scene;
import org.jetbrains.annotations.NotNull;

/**
 * This class serves as an abstract base class for all screens
 */
public abstract class BaseScreen implements Screen {

    @Override
    public @NotNull Scene getScene() {
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
