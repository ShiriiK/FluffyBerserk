package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.logic.Game;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

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

        Button deleteAccount = new Button("Delete Account"); // TODO

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
