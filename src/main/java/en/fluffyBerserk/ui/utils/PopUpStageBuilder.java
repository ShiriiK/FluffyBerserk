package main.java.en.fluffyBerserk.ui.utils;

import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.en.fluffyBerserk.Main;

public final class PopUpStageBuilder {

    /**
     * Builds default stage for showing pop-up windows
     */
    public static Stage buildDefaultStage() {
        Stage popupStage = new Stage();

        popupStage.initOwner(Main.app.getPrimaryStage());
        popupStage.initModality(Modality.WINDOW_MODAL);

        return popupStage;
    }
}
