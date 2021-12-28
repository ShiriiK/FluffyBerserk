package en.fluffyBerserk.gui.popups;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.utils.PopUpStageBuilder;

/**
 * This class serves as an abstract base class for all pop-ups
 */
public abstract class BasePopUp implements PopUp {

    // Stage specific for pop-up
    protected final Stage popUpStage;

    // Structure of BasePopUp
    public BasePopUp() {
        // Setting base structure for popup using PopUpStageBuilder in package utils
        popUpStage = PopUpStageBuilder.buildDefaultStage();

        initStage();
    }

    private void initStage() {
        // Add scene to pop-up
        initPopUpStage();

        // Set title of the pop-up
        popUpStage.setTitle(getPopUpTitle());

        // Attach hide event on stage close event
        popUpStage.addEventHandler(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ESCAPE)){
                    Main.app.hidePopUp();
                }
            }
        });
    }

    @Override
    public Stage getPopUpStage() {
        return popUpStage;
    }

    // Abstract methods used in classes extending this class
    protected abstract String getPopUpTitle();
    protected abstract void initPopUpStage();
}
