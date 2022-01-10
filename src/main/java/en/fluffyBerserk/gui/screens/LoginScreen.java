package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.form.LoginForm;
import en.fluffyBerserk.gui.utils.AttachCSS;
import en.fluffyBerserk.persistence.SelectTask;
import en.fluffyBerserk.persistence.models.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.TypedQuery;

public final class LoginScreen extends BaseScreen {

    private final LoginForm form = new LoginForm();

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();
        root.getStyleClass().addAll("vbox", "log-in");


        TextField usernameField = new TextField(form.getUsername());
        usernameField.setPromptText("Enter username");
        usernameField.textProperty().addListener((observable, oldValue, newValue) -> {
            form.setUsername(newValue);
        });


        root.getChildren().add(new Label("Username"));
        root.getChildren().add(usernameField);

        // Render errors if any
        for (String error : form.getErrorsForField("username")) {
            final Text errorText = new Text(error);
            errorText.setFill(Color.RED);
            root.getChildren().add(errorText);
        }

        final PasswordField passwordField = new PasswordField();
        passwordField.setText(form.getPassword());
        passwordField.setPromptText("Enter password");
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            form.setPassword(newValue);
        });

        root.getChildren().add(new Label("Password"));
        root.getChildren().add(passwordField);

        // Render errors if any
        for (String error : form.getErrorsForField("password")) {
            final Text errorText = new Text(error);
            errorText.setFill(Color.RED);
            root.getChildren().add(errorText);
        }

        final Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            form.clearErrors();

            if (!form.validate()) {
                Main.app.redrawScene();
                return;
            }

            final User user = new SelectTask<User>().singleNamedQuery(manager -> {
                TypedQuery<User> query = manager.createNamedQuery("User.byUsername", User.class);
                query.setParameter(1, form.getUsername());
                return query;
            });

            if (user == null) {
                form.addError("username", "User with this username does not exist!");
                Main.app.redrawScene();
                return;
            }

            // Check password hash
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            if (!encoder.matches(form.getPassword(), user.getPassword())) {
                form.addError("password", "Password is wrong!");
                Main.app.redrawScene();
                return;
            }

            Main.app.login(user);
            Main.app.changeScreen(new SaveSlotsScreen());
        });

        // Home screen
        final Button backButton = new Button("Back");
        backButton.setOnAction(event -> Main.app.changeScreen(new HomeScreen()));
        backButton.getStyleClass().add("back-button");


        root.getChildren().addAll(loginButton, backButton);

        Scene scene = new Scene(root);
        AttachCSS.attachCSS(scene);
        return scene;
    }

    @Override
    public void onEnter() {
        if (Main.app.isUserLoggedIn()) {
            throw new RuntimeException("Logged in user cannot go to login screen!");
        }
    }
}
