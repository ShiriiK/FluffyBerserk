package en.fluffyBerserk.gui.screens;

import javafx.scene.Scene;

public interface Screen {

    Scene getScene();

    void onEnter();

    void onLeave();
}
