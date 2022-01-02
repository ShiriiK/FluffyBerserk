package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.persistence.models.Character;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

public final class GameScreen extends BaseScreen {

    @NotNull
    private final Character character;

    public GameScreen(@NotNull Character character) {
        this.character = character;

        // TODO GAME
    }

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        root.getChildren().add(new Label("Game with character " + character.getName()));

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        if (!Main.app.isUserLoggedIn()) {
            throw new RuntimeException("User must be logged in to enter game screen!");
        }
    }
}
