package main.java.en.fluffyBerserk.ui.screens;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import main.java.en.fluffyBerserk.Main;

public class DefaultScreen implements Screen {

    private Scene scene;

    public DefaultScreen() {
        init();
    }

    private void init() {
        Group group = new Group();

        Button button = new Button("Switch to another scene");

        button.setOnAction(event -> {
            Main.app.changeScreen(new AnotherScreen());
        });

        group.getChildren().add(button);

        scene = new Scene(group);
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void onEnter() {
        System.out.println("Entered default screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left default screen");
    }
}
