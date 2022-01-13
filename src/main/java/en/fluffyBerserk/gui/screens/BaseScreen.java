package en.fluffyBerserk.gui.screens;

import javafx.scene.Scene;

public abstract class BaseScreen implements Screen {

    public Scene getScene() {
        return buildScene();
    }

    public void onEnter() {
        //
    }

    public void onLeave() {
        //
    }

    protected abstract Scene buildScene();
}
