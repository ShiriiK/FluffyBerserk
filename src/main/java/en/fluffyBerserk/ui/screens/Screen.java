package main.java.en.fluffyBerserk.ui.screens;

import javafx.scene.Scene;

public interface Screen {

    Scene getScene();

    void onEnter();

    void onLeave();
}
