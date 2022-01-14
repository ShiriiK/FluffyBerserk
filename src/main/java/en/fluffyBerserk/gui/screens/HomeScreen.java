package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.animations.SpriteImage;
import en.fluffyBerserk.game.animations.SpritesFactory;
import en.fluffyBerserk.gui.utils.AttachCSS;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public final class HomeScreen extends BaseScreen {

    @Override
    protected Scene buildScene() {
        final BorderPane root = new BorderPane();
        VBox buttons = new VBox();
        buttons.getStyleClass().add("vbox");

        // Login screen
        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> Main.app.changeScreen(new LoginScreen()));

        // Register screen
        final Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> Main.app.changeScreen(new RegisterScreen()));

        // Guest button
        Button guestButton = new Button("Continue as guest");
        guestButton.setOnAction(event -> {
            Main.app.changeScreen(new CharacterScreen(null));
        });

        buttons.getChildren().addAll(loginButton, registerButton, guestButton);

        // Kitty picture randomizer
        Image image = new SpriteImage(SpritesFactory.getRandomSprite(), 32, 0, 32, 32).getFrame();
        ImageView kitty = new ImageView(image);
        kitty.setFitWidth(300);
        kitty.setFitHeight(300);

        final VBox pic = new VBox();
        pic.getChildren().add(kitty);
        pic.setAlignment(Pos.CENTER);

        root.setLeft(buttons);
        root.setCenter(pic);

        Scene scene = new Scene(root);
        AttachCSS.attachCSS(scene);

        return scene;
    }

    @Override
    public void onEnter() {
        if (Main.app.isUserLoggedIn()) {
            throw new RuntimeException("Logged in user cannot go to home screen!");
        }
    }
}
