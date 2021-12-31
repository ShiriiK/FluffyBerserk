package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.base.GamePanel;
import en.fluffyBerserk.form.RegisterForm;
import en.fluffyBerserk.persistence.InsertTask;
import en.fluffyBerserk.persistence.SelectTask;
import en.fluffyBerserk.persistence.models.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.TypedQuery;
import java.security.SecureRandom;

public final class RegisterScreen extends BaseScreen {

    private final RegisterForm form = new RegisterForm();

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();
        root.setPadding(new Insets(15, 15, 15, 15));
        root.setSpacing(15.0);

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

        TextField passwordConfirmField = new PasswordField();
        passwordConfirmField.setText(form.getPasswordConfirm());
        passwordConfirmField.setPromptText("Enter password confirmation");
        passwordConfirmField.textProperty().addListener((observable, oldValue, newValue) -> {
            form.setPasswordConfirm(newValue);
        });

        root.getChildren().add(passwordConfirmField);

        // Render errors if any
        for (String error : form.getErrorsForField("passwordConfirm")) {
            Text errorText = new Text(error);
            errorText.setFill(Color.RED);
            root.getChildren().add(errorText);
        }

        Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> {
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

            if (existingUser != null) {
                form.addError("username", "This username is already used!");
                Main.app.redrawScene();
                return;
            }

            PasswordEncoder encoder = new BCryptPasswordEncoder(16, new SecureRandom());

            User user = new User();
            user.setUsername(form.getUsername());
            user.setPassword(encoder.encode(form.getPassword()));
            user.setIsAdmin((byte) 0);

            user = new InsertTask<User>().insert(user);

            Main.app.login(user);
            Main.app.changeScreen(new SaveSlotsScreen());
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> Main.app.changeScreen(new HomeScreen()));

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(
                registerButton,
                backButton
        );

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        if (Main.app.isUserLoggedIn()) {
            throw new RuntimeException("Logged in user cannot go to register screen!");
        }
    }
}
