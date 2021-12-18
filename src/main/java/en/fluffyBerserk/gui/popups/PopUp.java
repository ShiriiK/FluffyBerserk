package en.fluffyBerserk.gui.popups;

import javafx.stage.Stage;

public interface PopUp {

    // Returns pop-up stage -> currently used for hiding and showing of pop-up
    Stage getPopUpStage();

    // Message for console
    void onShow();

    // Message for console
    void onHide();
}
