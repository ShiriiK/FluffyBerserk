package en.fluffyBerserk.ui.popups;

import javafx.stage.Stage;

public interface PopUp {

    public Stage getPopUpStage();

    public void onShow();

    public void onHide();
}
