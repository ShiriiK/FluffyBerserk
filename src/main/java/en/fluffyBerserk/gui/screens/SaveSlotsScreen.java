package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.base.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * BaseScreen extension class that displays save slot screen.
 */

public class SaveSlotsScreen extends BaseScreen{

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        Button SaveSlot1 = new Button("Empty Save");
        Button SaveSlot2 = new Button("Empty Save");
        Button SaveSlot3 = new Button("Empty Save");

        Button LoadSave = new Button("Load Save");
        Button DeleteSave = new Button("Delete Save");
        Button DeleteAccount = new Button("Delete Account");
        Button Cancel = new Button("Cancel");

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(SaveSlot1, SaveSlot2, SaveSlot3);

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
