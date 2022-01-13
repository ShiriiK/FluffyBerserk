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
import org.jetbrains.annotations.NotNull;

public final class HomeScreen extends BaseScreen {
    private Scene scene;
    private BorderPane root;
    private VBox buttons;
    private Button loginButton, registerButton, guestButton;

    @Override
    protected Scene buildScene() {

        init();

        setUpButtons();
        final VBox pic = setUpKittyImage();

        buttons.getChildren().addAll(loginButton, registerButton, guestButton);

        root.setLeft(buttons);
        root.setCenter(pic);

        return scene;
    }

    @NotNull
    private VBox setUpKittyImage() {
        // Kitty picture randomizer
        Image image = new SpriteImage(SpritesFactory.getRandomSprite(), 32, 0, 32, 32).getFrame();
        ImageView kitty = new ImageView(image);
        kitty.setFitWidth(300);
        kitty.setFitHeight(300);

        final VBox pic = new VBox();
        pic.getChildren().add(kitty);
        pic.setAlignment(Pos.CENTER);
        return pic;
    }

    private void setUpButtons() {
        // Login screen
        loginButton = new Button("Login");
        loginButton.setOnAction(event -> Main.app.changeScreen(new LoginScreen()));

        // Register screen
        registerButton = new Button("Register");
        registerButton.setOnAction(event -> Main.app.changeScreen(new RegisterScreen()));

        // Guest button
        guestButton = new Button("Continue as guest");
        guestButton.setOnAction(event -> {
            Main.app.changeScreen(new CharacterScreen(null));
        });
    }

    public void init() {
        root = new BorderPane();

        buttons = new VBox();
        buttons.getStyleClass().add("vbox");

        scene = new Scene(root);
        AttachCSS.attachCSS(scene);

    }

    @Override
    public void onEnter() {
        if (Main.app.isUserLoggedIn()) {
            throw new RuntimeException("Logged in user cannot go to home screen!");
        }
    }
}
