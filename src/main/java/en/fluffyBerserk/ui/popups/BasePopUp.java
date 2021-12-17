package en.fluffyBerserk.ui.popups;

import javafx.stage.Stage;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.ui.utils.PopUpStageBuilder;

/**
 * This class serves as an abstract base class for
 * all pop-ups
 */
public abstract class BasePopUp implements PopUp {

    protected final Stage popUpStage;

    public BasePopUp() {
        popUpStage = PopUpStageBuilder.buildDefaultStage();
        initStage();
    }

    private void initStage() {
        initPopUpStage();

        // Set title of the pop-up
        popUpStage.setTitle(getPopUpTitle());

        // Attach hide event on stage close event
        popUpStage.setOnCloseRequest(event -> Main.app.hidePopUp());
    }

    @Override
    public Stage getPopUpStage() {
        return popUpStage;
    }

    protected abstract String getPopUpTitle();

    protected abstract void initPopUpStage();
}
