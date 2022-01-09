package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.animations.SpriteImage;
import en.fluffyBerserk.gui.animations.SpritesFactory;
import en.fluffyBerserk.gui.utils.AttachCSS;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Screen representing Home screen
 */

public final class HomeScreen extends Screen {


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

        // Safe-zone screen
        Button guestButton = new Button("Continue as guest");
        guestButton.setOnAction(event -> {
            try {
                Main.app.changeScreen(new SafeZoneScreen());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // TODO guest button

        buttons.getChildren().addAll(loginButton, registerButton, guestButton);

        // Kitty picture randomizer
        int index = getIndex();
        Image image = new SpriteImage(SpritesFactory.getImages()[index], 32, 0, 32, 32).getFrame();
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
        System.out.println("Entered home screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left home screen");
    }

    private int getIndex() {
        return (int) ((Math.random() * (SpritesFactory.getImages().length - 1)) + 1);
    }
}
