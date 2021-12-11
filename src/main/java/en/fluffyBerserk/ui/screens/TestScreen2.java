package en.fluffyBerserk.ui.screens;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.ui.popups.TestPopUp2;

public final class TestScreen2 extends BaseScreen {

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        Label label = new Label("This is test screen 2");

        Button screenButton = new Button("Test screen 1");
        screenButton.setOnAction(event -> Main.app.changeScreen(new TestScreen1()));

        Button popUpButton = new Button("Test pop-up 2");
        popUpButton.setOnAction(e -> Main.app.showPopUp(new TestPopUp2()));

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
