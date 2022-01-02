package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.logic.Game;
import en.fluffyBerserk.persistence.DeleteTask;
import en.fluffyBerserk.persistence.models.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

import java.util.Optional;

public final class SaveSlotsScreen extends BaseScreen {

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        Button saveSlot1 = new Button("Empty Save");
        saveSlot1.setStyle("-fx-border-color: Black");
        saveSlot1.setStyle("-fx-font-size: 32");
        Button saveSlot2 = new Button("Empty Save");
        saveSlot2.setStyle("-fx-border-color: Black");
        saveSlot2.setStyle("-fx-font-size: 32");
        Button saveSlot3 = new Button("Empty Save");
        saveSlot3.setStyle("-fx-border-color: Black");
        saveSlot3.setStyle("-fx-font-size: 32");

        saveSlot1.setOnAction(event -> {
        });

        saveSlot2.setOnAction(event -> {
        });

        saveSlot3.setOnAction(event -> {
        });

        Button loadSave = new Button("Load Save"); // TODO needs to actually make difference between loaded saves
        loadSave.setOnAction(event -> {
            Main.app.changeScreen(new EditScreen(new Game()));
        });

        Button deleteAccount = new Button("Delete Account");
        deleteAccount.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm deleting your account");
            alert.setHeaderText("Are you sure you want to delete your account?");
            alert.setContentText("If the account will be deleted, you will lose your progress in the game.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                User user = Main.app.getUser();
                Main.app.logout();
                if (user != null && new DeleteTask<User>().delete(user)) {
                    Main.app.changeScreen(new HomeScreen());
                }
            }
        });

        Button logOutButton = new Button("Log out");
        logOutButton.setOnAction(event -> {
            Main.app.logout();
            Main.app.changeScreen(new HomeScreen());
        });

        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.getChildren().addAll(
                saveSlot1,
                saveSlot2,
                saveSlot3,
                loadSave,
                deleteAccount,
                logOutButton
        );

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        if (!Main.app.isUserLoggedIn()) {
            throw new RuntimeException("User must be logged in to enter save slot screen!");
        }
    }
}
