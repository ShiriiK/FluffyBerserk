package en.fluffyBerserk.gui.screens;

import javafx.geometry.Insets;
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

public final class HomeScreen extends BaseScreen {

    @Override
    protected Scene buildScene() {
        final BorderPane root = new BorderPane();
        root.setPadding(new Insets(15, 15, 15, 15));

        VBox buttons = new VBox();

        // Login screen
        final Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> Main.app.changeScreen(new LoginScreen()));

        // Register screen
        final Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> Main.app.changeScreen(new RegisterScreen()));

        // Safe-zone screen
        final Button guestButton = new Button("Continue as guest");

        // TODO guest button

        buttons.getChildren().addAll(loginButton, registerButton, guestButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10.0);

        // Temporary creating of image
        final Image image = new Image("player/fluf1.png");
        final PixelReader reader = image.getPixelReader();
        final ImageView kitty = new ImageView(new WritableImage(reader, 32, 0, 32, 32));
        kitty.setFitHeight(200);
        kitty.setFitWidth(200);

        final VBox pic = new VBox();
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
