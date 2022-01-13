package en.fluffyBerserk.game.control;

import en.fluffyBerserk.game.Game;
import en.fluffyBerserk.game.logic.objects.creatures.player.Player;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import org.jetbrains.annotations.Nullable;

public class KeyHandler {

    // Reference to the key currently handling moving on axis Y
    private static @Nullable KeyCode moveY = null;

    // Reference to the key currently handling moving on axis X
    private static @Nullable KeyCode moveX = null;

    public static void attachHandlers(Game game, Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    game.getPlayer().setMoveY(-Player.PLAYER_SPEED);
                    moveY = KeyCode.W;
                    break;
                case S:
                    game.getPlayer().setMoveY(Player.PLAYER_SPEED);
                    moveY = KeyCode.S;
                    break;
                case A:
                    game.getPlayer().setMoveX(-Player.PLAYER_SPEED);
                    moveX = KeyCode.A;
                    break;
                case D:
                    game.getPlayer().setMoveX(Player.PLAYER_SPEED);
                    moveX = KeyCode.D;
                    break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case W:
                case S:
                    if (moveY == event.getCode()) {
                        game.getPlayer().setMoveY(0F);
                        moveY = null;
                    }
                    break;
                case A:
                case D:
                    if (moveX == event.getCode()) {
                        game.getPlayer().setMoveX(0F);
                        moveX = null;
                    }
                    break;
            }
        });
    }
}
