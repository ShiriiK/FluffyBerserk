package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.logic.objects.creatures.player.Player;
import javafx.scene.Scene;

/**
 * Interface for screens implemented by BaseScreen
 */

public interface Screen {

    Scene getScene();

    // Message for console
    void onEnter();

    // Message for console
    void onLeave();
}
