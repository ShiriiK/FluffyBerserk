package en.fluffyBerserk.gui.screens;

import javafx.scene.Scene;

/**
 * Interface for screens implemented by BaseScreen
 */

public interface Screen {

    // Returns scene -> currently used for switching scenes
    Scene getScene();

    // Message for console
    void onEnter();

    // Message for console
    void onLeave();
}
