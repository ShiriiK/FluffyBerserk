package main.java.en.fluffyBerserk.ui.screens;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import main.java.en.fluffyBerserk.Main;
import main.java.en.fluffyBerserk.ui.popups.TestPopUp;

public final class TestScreen2 implements Screen {

    private Scene scene;

    public TestScreen2() {
        init();
    }

    private void init() {
        VBox root = new VBox();

        Label label = new Label("This is test screen 2");

        Button screenButton = new Button("Test screen 1");
        screenButton.setOnAction(event -> Main.app.changeScreen(new TestScreen1()));

        Button popUpButton = new Button("Test pop-up");
        popUpButton.setOnAction(e -> Main.app.showPopUp(new TestPopUp()));

        root.getChildren().addAll(label, screenButton, popUpButton);

        scene = new Scene(root);
    }

    @Override
    public Scene getScene() {
        return scene;
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
