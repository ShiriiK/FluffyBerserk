package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.utils.PopUpStageBuilder;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * This class serves as an abstract base class for all pop-ups
 */
public abstract class BasePopUp implements PopUp {

    protected final Stage popUpStage;

    // Structure of BasePopUp
    public BasePopUp() {
        // Setting base structure for popup using PopUpStageBuilder in package utils
        popUpStage = PopUpStageBuilder.buildDefaultStage();

        initStage();
    }

    private void initStage() {
        initPopUpStage();

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

    // Abstract methods used in classes extending this class
    protected abstract void initPopUpStage();
}
