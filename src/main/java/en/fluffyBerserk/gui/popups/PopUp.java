package en.fluffyBerserk.gui.popups;
import javafx.stage.Popup;

/**
 * Interface for pop-up implemented by BasePopUp
 */

public interface PopUp {

    // Returns pop-up
    Popup getPopUp();

    // Message for console
    void onShow();

    // Message for console
    void onHide();
}
