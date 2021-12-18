package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.base.Main;
import en.fluffyBerserk.gui.popups.PopUpMenu;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

/**
 * BaseScreen extension class that displays safe-zone screen.
 */

public class SafeZoneScreen extends BaseScreen{

    @Override
    protected Scene buildScene() {
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root);

        // Attach event on scene for displaying menu
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE) {
                    Main.app.showPopUp(new PopUpMenu());
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
