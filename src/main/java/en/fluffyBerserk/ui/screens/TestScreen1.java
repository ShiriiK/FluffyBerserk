package en.fluffyBerserk.ui.screens;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.ui.popups.TestPopUp1;

public final class TestScreen1 extends BaseScreen {

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        Label label = new Label("This is test screen 1");

        Button screenButton = new Button("Test screen 2");
        screenButton.setOnAction(event -> Main.app.changeScreen(new TestScreen2()));

        Button popUpButton = new Button("Test pop-up 1");
        popUpButton.setOnAction(e -> Main.app.showPopUp(new TestPopUp1()));

        root.getChildren().addAll(label, screenButton, popUpButton);

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        System.out.println("Entered test screen 1 screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left test screen 1 screen");
    }
}