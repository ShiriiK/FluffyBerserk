package main.java.en.fluffyBerserk.ui.popups;

import javafx.stage.Stage;
import main.java.en.fluffyBerserk.Main;
import main.java.en.fluffyBerserk.ui.utils.PopUpStageBuilder;

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

    protected abstract String getPopUpTitle();

    protected abstract void initPopUpStage();

    @Override
    public Stage getPopUpStage() {
        return popUpStage;
    }
}
