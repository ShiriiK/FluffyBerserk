package en.fluffyBerserk.gui.utils;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import en.fluffyBerserk.Main;
import javafx.stage.StageStyle;
import org.jetbrains.annotations.NotNull;

public final class PopUpBuilder {

    /**
     * Builds default stage for showing pop-up windows
     */
    public static @NotNull Popup buildDefaultPopUp() {
        Popup popup =  new Popup();

        popup.setAutoHide(true);
        popup.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.ESCAPE)){
                Main.app.hidePopUp();
            }
        });

        return popup;
    }
}
