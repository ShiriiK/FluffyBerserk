package en.fluffyBerserk.game.graphics;

import en.fluffyBerserk.game.Game;
import en.fluffyBerserk.game.control.KeyHandler;
import en.fluffyBerserk.gui.utils.AttachCSS;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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
