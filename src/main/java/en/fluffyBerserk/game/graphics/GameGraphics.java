package en.fluffyBerserk.game.graphics;

import en.fluffyBerserk.game.Constants;
import javafx.scene.canvas.Canvas;

public final class GameGraphics {

    private final Canvas canvas = new Canvas(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

    public Canvas getCanvas() {
        return canvas;
    }
}
