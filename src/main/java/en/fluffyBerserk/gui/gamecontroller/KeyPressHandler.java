package en.fluffyBerserk.gui.gamecontroller;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyPressHandler implements javafx.event.EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {
        KeyCode code = event.getCode();

        if (!EventHandler.inputList.contains(code)) {
            EventHandler.inputList.add(code);
        }
    }
}
