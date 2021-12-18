package en.fluffyBerserk.gui.utils;

import javafx.stage.Modality;
import javafx.stage.Stage;
import en.fluffyBerserk.base.Main;
import org.jetbrains.annotations.NotNull;

public final class PopUpStageBuilder {

    /**
     * Builds default stage for showing pop-up windows
     */
    public static @NotNull Stage buildDefaultStage() {
        Stage popupStage = new Stage();

        popupStage.initOwner(Main.app.getPrimaryStage());
        popupStage.initModality(Modality.WINDOW_MODAL);

        return popupStage;
    }
}
