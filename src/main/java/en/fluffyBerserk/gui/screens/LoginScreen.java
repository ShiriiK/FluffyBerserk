package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.form.LoginForm;
import en.fluffyBerserk.persistence.SelectTask;
import en.fluffyBerserk.persistence.models.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import en.fluffyBerserk.Main;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javax.persistence.TypedQuery;

public final class LoginScreen extends BaseScreen {

    private final LoginForm form = new LoginForm();

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        TextField usernameField = new TextField(form.getUsername());
        usernameField.setPromptText("Enter username");
        usernameField.textProperty().addListener((observable, oldValue, newValue) -> {
            form.setUsername(newValue);
        });

        root.getChildren().add(usernameField);

        // Render errors if any
        for (String error : form.getErrorsForField("username")) {
            Text errorText = new Text(error);
            errorText.setFill(Color.RED);
            root.getChildren().add(errorText);
        }

        TextField passwordField = new PasswordField();
        passwordField.setText(form.getPassword());
        passwordField.setPromptText("Enter password");
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            form.setPassword(newValue);
        });

        root.getChildren().add(passwordField);

        // Render errors if any
        for (String error : form.getErrorsForField("password")) {
            Text errorText = new Text(error);
            errorText.setFill(Color.RED);
            root.getChildren().add(errorText);
        }

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            form.clearErrors();

            if (!form.validate()) {
                Main.app.redrawScene();
                return;
            }

            User existingUser = new SelectTask<User>().singleNamedQuery(manager -> {
                TypedQuery<User> query = manager.createNamedQuery("User.byUsername", User.class);
                query.setParameter(1, form.getUsername());
                return query;
            });

            if (existingUser == null) {
                form.addError("username", "User with this username does not exist!");
                Main.app.redrawScene();
                return;
            }

            // check password

            Main.app.login(existingUser);
            Main.app.changeScreen(new SaveSlotsScreen());
        });

        // Home screen
        Button closeButton = new Button("Back");
        closeButton.setOnAction(event -> Main.app.changeScreen(new HomeScreen()));

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(
                loginButton,
                closeButton
        );

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        if (Main.app.isUserLoggedIn()) {
            throw new RuntimeException("Logged in user cannot go to login screen!");
        }
    }
}
