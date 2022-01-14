package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.game.Game;
import en.fluffyBerserk.gui.utils.PopUpBuilder;
import javafx.stage.Stage;

/**
 * This class serves as an abstract base class for all pop-ups
 */
public abstract class PopUp {

    protected final Stage popUpStage;

    // Structure of PopUp
    public PopUp() {
        popUpStage = PopUpBuilder.buildDefaultStage();
        initPopUpStage();
    }

    public Stage getPopUpStage() {
        return popUpStage;
    }

    // Abstract methods

    protected abstract void initPopUpStage();

    public abstract void onShow();

    public abstract void onHide();
}
