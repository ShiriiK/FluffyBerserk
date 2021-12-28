package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.base.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * BaseScreen extension class that displays register screen.
 */

public class RegisterScreen extends BaseScreen{

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        TextField userName = new TextField("User name");
        TextField password = new TextField("Password");
        TextField password2 = new TextField("Repeat password");

        // Save slot screen
        Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> { Main.app.changeScreen(new SaveSlotsScreen());});

        // Home screen
        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> Main.app.changeScreen(new HomeScreen()));

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(userName,password,password2, registerButton,closeButton);

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        System.out.println("Entered register screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left register screen");
    }
}
