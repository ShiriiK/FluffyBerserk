package en.fluffyBerserk.gui.gamecontroller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyPressHandler implements EventHandler<KeyEvent> {
    public boolean UP, LEFT, DOWN, RIGHT;

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                UP = true;
                break;
            case A:
                LEFT = true;
                break;
            case S:
                DOWN = true;
                break;
            case D:
                RIGHT = true;
                break;
        }
    }
}
