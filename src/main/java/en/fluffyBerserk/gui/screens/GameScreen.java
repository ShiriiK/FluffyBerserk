package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game2.Game;
import en.fluffyBerserk.gui.popups.PopUpMenu;
import en.fluffyBerserk.persistence.models.Character;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import org.jetbrains.annotations.NotNull;

public final class GameScreen extends BaseScreen {

    @NotNull
    private final Game game;

    public GameScreen(@NotNull final Character character) {
        game = new Game(character);
    }

    @Override
    protected Scene buildScene() {
        final BorderPane root = new BorderPane();

        final Scene scene = new Scene(root);

        // Attach event on scene for displaying menu
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                Main.app.showPopUp(new PopUpMenu());
            }
        });

        return scene;
    }
}
