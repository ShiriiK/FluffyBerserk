package en.fluffyBerserk.gui.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import en.fluffyBerserk.base.Main;

/**
 * BaseScreen extension class that displays login screen.
 */

public final class LoginScreen extends BaseScreen {

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        TextField userName = new TextField("User name");
        TextField password = new TextField("Password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> Main.app.changeScreen(new SaveSlotsScreen()));

        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> Main.app.changeScreen(new HomeScreen()));

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(userName,password,loginButton,closeButton);

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        System.out.println("Entered login screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left login screen");
    }
}
