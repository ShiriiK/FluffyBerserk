package en.fluffyBerserk.gui.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import en.fluffyBerserk.Main;

/**
 * BaseScreen extension class that displays home screen.
 */

public final class HomeScreen extends BaseScreen {

    @Override
    protected Scene buildScene() {
        BorderPane root = new BorderPane();
        VBox buttons = new VBox();

        // Login screen
        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> Main.app.changeScreen(new LoginScreen()));

        // Register screen
        Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> Main.app.changeScreen(new RegisterScreen()));

        // Safe-zone screen
        Button guestButton = new Button("Continue as guest");
        guestButton.setOnAction(event -> Main.app.changeScreen(new SafeZoneScreen()));

        buttons.getChildren().addAll(loginButton,registerButton,guestButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(5);

        // Temporary creating of image
        Image image = new Image("player/fluf1.png");
        PixelReader reader = image.getPixelReader();
        ImageView kitty = new ImageView(new WritableImage(reader,32,0, 32, 32));
        kitty.setFitHeight(200);
        kitty.setFitWidth(200);

        VBox pic = new VBox();
        pic.getChildren().add(kitty);
        pic.setAlignment(Pos.CENTER);

        root.setLeft(buttons);
        root.setCenter(pic);

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        if (Main.app.isUserLoggedIn()) {
            throw new RuntimeException("Logged in user cannot go to home screen!");
        }
    }
}
