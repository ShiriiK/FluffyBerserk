package en.fluffyBerserk.gui.utils;

import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.gamecontrolls.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public final class GameSceneBuilder {

    public static Scene buildScene(Game game) {
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root);
        AttachCSS.attachCSS(scene);

        root.getChildren().add(game.getGameGraphics().getCanvas());

        KeyHandler.attachHandlers(game, scene);

        return scene;
    }
}
