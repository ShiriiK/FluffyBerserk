package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.persistence.DeleteTask;
import en.fluffyBerserk.persistence.models.Character;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public final class CharacterDetailScreen extends Screen {

    @NotNull
    private final Character character;

    public CharacterDetailScreen(@NotNull final Character character) {
        this.character = character;
    }

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();
        root.setPadding(new Insets(15, 15, 15, 15));
        root.setSpacing(10.0);
        root.setAlignment(Pos.CENTER);

        final Label nameLabel = new Label("Name");
        final Text nameText = new Text(character.getName());

        final Label staminaLabel = new Label("Stamina");
        final Text staminaText = new Text(character.getStamina() + "");

        final Label strengthLabel = new Label("Strength");
        final Text strengthText = new Text(character.getStrength() + "");

        final Label armorLabel = new Label("Armor");
        final Text armorText = new Text(character.getArmor() + "");

        final Label intellectLabel = new Label("Intellect");
        final Text intellectText = new Text(character.getIntellect() + "");

        final Button backButton = new Button("Back to profile");
        backButton.setOnAction(event -> {
            Main.app.changeScreen(new SaveSlotsScreen());
        });

        final Button gameButton = new Button("Play");
        gameButton.setOnAction(event -> {
            Main.app.changeScreen(new GameScreen(character));
        });

        final Button deleteButton = new Button("Delete character");
        deleteButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm deleting your character");
            alert.setHeaderText("Are you sure you want to delete your character?");
            alert.setContentText("If the character will be deleted, you will lose your progress in the game.");

            ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Delete");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                if (new DeleteTask<Character>().delete(character)) {
                    Main.app.changeScreen(new SaveSlotsScreen());
                }
            }
        });

        final FlowPane buttonPane = new FlowPane();
        buttonPane.setHgap(5.0);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.getChildren().add(backButton);
        buttonPane.getChildren().add(deleteButton);
        buttonPane.getChildren().add(gameButton);

        root.getChildren().addAll(
                nameLabel,
                nameText,
                staminaLabel,
                staminaText,
                strengthLabel,
                strengthText,
                armorLabel,
                armorText,
                intellectLabel,
                intellectText,
                buttonPane
        );

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        if (!Main.app.isUserLoggedIn()) {
            throw new RuntimeException("User must be logged in to enter character detail screen!");
        }
        System.out.println("Entered character detail screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left character detail screen");
    }
}
