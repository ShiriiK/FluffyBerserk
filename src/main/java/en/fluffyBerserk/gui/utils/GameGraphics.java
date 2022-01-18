package en.fluffyBerserk.gui.utils;

import en.fluffyBerserk.Constants;
import javafx.scene.canvas.Canvas;

public final class GameGraphics {

    private final Canvas canvas = new Canvas(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

    public Canvas getCanvas() {
        return canvas;
    }
}
