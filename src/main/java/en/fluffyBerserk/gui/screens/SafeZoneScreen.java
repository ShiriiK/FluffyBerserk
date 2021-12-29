package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.popups.PopUpFactory;
import en.fluffyBerserk.gui.popups.PopUpMenu;
import en.fluffyBerserk.gui.utils.Observer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;

/**
 * BaseScreen extension class that displays safe-zone screen.
 */

public class SafeZoneScreen extends BaseScreen implements Observer {

    @Override
    protected Scene buildScene() {
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("fluf.css");

        Popup popup = PopUpFactory.getPopUpMenu();

        // Attach event on scene for displaying menu
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE) {

                    popup.show(Main.app.getPrimaryStage());
                    double x = Main.app.getPrimaryStage().getX() + 0.5*(Main.app.getPrimaryStage().getWidth()-300);
                    popup.setX(x);
                    double y  = Main.app.getPrimaryStage().getY() + 0.5*(Main.app.getPrimaryStage().getHeight()-500);
                    popup.setY(y);
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

    @Override
    public void update() {

    }
}
