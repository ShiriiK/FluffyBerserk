package en.fluffyBerserk.gui.popups;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.utils.PopUpStageBuilder;

/**
 * This class serves as an abstract base class for all pop-ups
 */
public abstract class BasePopUp implements PopUp {

    protected final Stage popUpStage;

    public BasePopUp() {
        // Setting base structure for popup using PopUpStageBuilder in package utils
        popUpStage = PopUpStageBuilder.buildDefaultStage();

        initStage();
    }

    private void initStage() {
        initPopUpStage();

        popUpStage.setTitle(getPopUpTitle());

        popUpStage.setOnCloseRequest(event -> Main.app.hidePopUp());

        // Attach hide event on stage close event
        popUpStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.ESCAPE)) {
                Main.app.hidePopUp();
            }
        });
    }

    @Override
    public Stage getPopUpStage() {
        return popUpStage;
    }

    protected abstract String getPopUpTitle();

    protected abstract void initPopUpStage();
}
