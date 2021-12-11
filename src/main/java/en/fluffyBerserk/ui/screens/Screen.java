package main.java.en.fluffyBerserk.ui.screens;

import javafx.scene.Scene;

public interface Screen {

    public Scene getScene();

    public void onEnter();

    public void onLeave();
}
