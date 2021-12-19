package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.base.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * BaseScreen extension class that displays save slot screen.
 */

public class SaveSlotsScreen extends BaseScreen{
    private String string;

    @Override
    protected Scene buildScene() {
        string = null;
        VBox root = new VBox();

        Button saveSlot1 = new Button("Empty Save");
        saveSlot1.setStyle("-fx-border-color: Black");
        Button saveSlot2 = new Button("Empty Save");
        saveSlot2.setStyle("-fx-border-color: Black");
        Button saveSlot3 = new Button("Empty Save");
        saveSlot3.setStyle("-fx-border-color: Black");

        saveSlot1.setOnAction(event -> {
            saveSlot1.setStyle("-fx-border-color: Green");
            saveSlot2.setStyle("-fx-border-color: Black");
            saveSlot3.setStyle("-fx-border-color: Black");
            string = "saveSlot1";
        });

        saveSlot1.setOnAction(event -> {
            saveSlot1.setStyle("-fx-border-color: Black");
            saveSlot2.setStyle("-fx-border-color: Green");
            saveSlot3.setStyle("-fx-border-color: Black");
            string = "saveSlot2";
        });

        saveSlot3.setOnAction(event -> {
            saveSlot1.setStyle("-fx-border-color: Black");
            saveSlot2.setStyle("-fx-border-color: Black");
            saveSlot3.setStyle("-fx-border-color: Green");
            string = "saveSlot3";
        });

        Button loadSave = new Button("Load Save");
        loadSave.setOnAction(event -> { //TODO make difference between saves
            Main.app.changeScreen(new EditScreen());
        });
        Button deleteSave = new Button("Delete Save"); //TODO
        Button deleteAccount = new Button("Delete Account"); //TODO
        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> {
            Main.app.changeScreen(new HomeScreen());
        });

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(saveSlot1, saveSlot2, saveSlot3, loadSave, deleteSave, deleteAccount, cancel);

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        {
            System.out.println("Entered save slot screen");
        }
    }

    @Override
    public void onLeave() {
        {
            System.out.println("Left save slot screen");
        }
    }
}
