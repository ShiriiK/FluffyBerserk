package en.fluffyBerserk.gui.gamecontroller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyReleaseHandler implements javafx.event.EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent evt) {

        KeyCode code = evt.getCode();

        if (EventHandler.inputList.contains(code) )
            EventHandler.inputList.remove( code );
    }
}
