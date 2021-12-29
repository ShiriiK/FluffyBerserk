package en.fluffyBerserk.gui.popups;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.utils.PopUpBuilder;

/**
 * This class serves as an abstract base class for all pop-ups
 */
public abstract class BasePopUp implements PopUp {

    protected final Popup popup;

    // Structure of BasePopUp
    public BasePopUp() {
        // Setting base structure for popup using PopUpStageBuilder in package utils
        popup = PopUpBuilder.buildDefaultPopUp();

        initPopUp();
    }

    private void initPopUp() {
        // Add scene to pop-up
        initPopUpStage();

        // Attach hide event on stage close event

    }

    @Override
    public Popup getPopUp() {
        return popup;
    }

    // Abstract methods used in classes extending this class
    protected abstract void initPopUpStage();
}
