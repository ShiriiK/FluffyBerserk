package en.fluffyBerserk.gui.screens;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import en.fluffyBerserk.base.Main;
import en.fluffyBerserk.gui.popups.PopUpHelp;

public final class TestScreen2 extends BaseScreen {

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        Label label = new Label("This is test screen 2");

        Button screenButton = new Button("Test screen 1");
        screenButton.setOnAction(event -> Main.app.changeScreen(new TestScreen1()));

        Button popUpButton = new Button("Test pop-up 2");
        popUpButton.setOnAction(e -> Main.app.showPopUp(new PopUpHelp()));

        root.getChildren().addAll(label, screenButton, popUpButton);

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        System.out.println("Entered test screen 2 screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left test screen 2 screen");
    }
}
