package en.fluffyBerserk.gui.utils;

import en.fluffyBerserk.Main;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jetbrains.annotations.NotNull;

/**
 * Class with utils for pop-ups
 */
public final class PopUpBuilder {

    /**
     * Builds default structure for pop-up
     */
    public static @NotNull Stage buildDefaultStage() {
        Stage popUpStage = new Stage();

        popUpStage.initOwner(Main.app.getPrimaryStage());
        popUpStage.initModality(Modality.WINDOW_MODAL);
        popUpStage.initStyle(StageStyle.UNDECORATED);
        popUpStage.initStyle(StageStyle.TRANSPARENT);

        popUpStage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ESCAPE)) {
                    Main.app.hidePopUp();
                }
            }
        });

        return popUpStage;
    }

    /**
     * Aligns popupStage in center of primaryStage
     */
    public static void alignPopUp(Stage popUpStage) {
        double x = Main.app.getPrimaryStage().getX() + 0.5 * (Main.app.getPrimaryStage().getWidth() - popUpStage.getWidth());
        popUpStage.setX(x);

        double y = Main.app.getPrimaryStage().getY() + 0.5 * (Main.app.getPrimaryStage().getHeight() - popUpStage.getHeight());
        popUpStage.setY(y);
    }
}
