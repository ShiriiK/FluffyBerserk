package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.game.Game;
import en.fluffyBerserk.game.graphics.GameSceneBuilder;
import en.fluffyBerserk.persistence.models.Character;
import javafx.scene.Scene;
import org.jetbrains.annotations.NotNull;

public final class GameScreen extends BaseScreen {

    private static Game game;

    public GameScreen(@NotNull final Character character) {
        (game = new Game(character)).getGameLoop().start();
    }

    @Override
    protected Scene buildScene() {
        return GameSceneBuilder.buildScene(game);
    }
}
