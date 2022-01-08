package en.fluffyBerserk.gamecontrol;

import en.fluffyBerserk.Main;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class KeyManager extends Handler {

    public static void attachHandlers(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
                    case ESCAPE:
                        Main.app.showPopUp(popUpMenu);
                        break;
                    case SPACE:
                        SHOOT = true;
                        break;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
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
                    case SPACE:
                        SHOOT = false;
                        break;
                }
            }
        });
    }
}
