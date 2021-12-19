package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.base.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * BaseScreen extension class that displays edit screen.
 */

public class EditScreen extends BaseScreen{
    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        Label label1 = new Label("Character name");
        TextField name = new TextField("enter name");

        // Safe-zone
        Button saveCharacter = new Button("Save character");
        saveCharacter.setOnAction(event -> Main.app.changeScreen(new SafeZoneScreen()));

        // Save slots
        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> Main.app.changeScreen(new SaveSlotsScreen()));

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label1, name,saveCharacter,cancel);

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        System.out.println("Entered edit screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left edit screen");
    }
}
