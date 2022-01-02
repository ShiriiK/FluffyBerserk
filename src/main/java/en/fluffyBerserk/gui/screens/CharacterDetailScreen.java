package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.persistence.models.Character;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
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

        root.getChildren().addAll();

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        if (!Main.app.isUserLoggedIn()) {
            throw new RuntimeException("User must be logged in to enter character detail screen!");
        }
    }
}
