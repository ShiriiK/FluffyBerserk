package main.java.en.fluffyBerserk.ui.screens;

import javafx.scene.Scene;

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
