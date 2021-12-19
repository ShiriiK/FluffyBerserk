package en.fluffyBerserk.gui.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * BaseScreen extension class that displays save slot screen.
 */

public class SaveSlotsScreen extends BaseScreen{

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        Button saveSlot1 = new Button("Empty Save");
        Button saveSlot2 = new Button("Empty Save");
        Button saveSlot3 = new Button("Empty Save");

        Button loadSave = new Button("Load Save");
        Button deleteSave = new Button("Delete Save");
        Button deleteAccount = new Button("Delete Account");
        Button cancel = new Button("Cancel");

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
