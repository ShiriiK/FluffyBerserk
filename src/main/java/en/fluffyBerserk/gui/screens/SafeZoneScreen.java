package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.popups.PopUpFactory;
import en.fluffyBerserk.gui.popups.PopUpMenu;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;

/**
 * BaseScreen extension class that displays safe-zone screen.
 */

public class SafeZoneScreen extends BaseScreen {

    @Override
    protected Scene buildScene() {
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("fluf.css");

        PopUpMenu popUpMenu = new PopUpMenu();
        Popup menuPopUp = popUpMenu.getPopUp();

        // Attach event on scene for displaying menu
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE) {
                    popUpCenter.centerPopUp(menuPopUp);

                    Main.app.showPopUp(popUpMenu);
                    menuPopUp.show(Main.app.getPrimaryStage());
                }
            }
        });

        return scene;
    }

    @Override
    public void onEnter() {
        System.out.println("Entered safe-zone screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left safe-zone screen");
    }

}
