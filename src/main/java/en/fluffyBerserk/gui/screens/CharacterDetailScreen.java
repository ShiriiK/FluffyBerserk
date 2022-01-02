package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.persistence.models.Character;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

public final class CharacterDetailScreen extends BaseScreen {

    @NotNull
    private final Character character;

    public CharacterDetailScreen(@NotNull Character character) {
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

        final FlowPane buttonPane = new FlowPane();
        buttonPane.setHgap(5.0);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.getChildren().add(backButton);
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
    }
}
