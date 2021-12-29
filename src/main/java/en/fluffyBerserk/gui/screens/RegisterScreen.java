package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.form.RegisterForm;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class RegisterScreen extends BaseScreen {

    private final RegisterForm form = new RegisterForm();

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        TextField usernameField = new TextField(form.getUsername());
        usernameField.setPromptText("User name");
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
        System.out.println("Entered register screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left register screen");
    }
}
