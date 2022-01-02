package en.fluffyBerserk.gui.screens;

import javafx.scene.Scene;
import org.jetbrains.annotations.NotNull;

public interface Screen {

    @NotNull Scene getScene();

    // Message for console
    void onEnter();

    // Message for console
    void onLeave();
}
