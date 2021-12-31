package en.fluffyBerserk.gui.gamecontroller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyReleaseHandler implements EventHandler<KeyEvent> {
    public boolean UP, LEFT, DOWN, RIGHT;

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                UP = false;
                break;
            case A:
                LEFT = false;
                break;
            case S:
                DOWN = false;
                break;
            case D:
                RIGHT = false;
                break;
        }
    }
}
