package en.fluffyBerserk.gui.popups;
import javafx.stage.Popup;
import javafx.stage.Stage;

public interface PopUp {

    // Returns pop-up
    Stage getPopUpStage();

    void onShow();

    void onHide();
}
