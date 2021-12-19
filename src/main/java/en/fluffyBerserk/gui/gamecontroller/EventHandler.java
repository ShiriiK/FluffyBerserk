package en.fluffyBerserk.gui.gamecontroller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {

    public static ArrayList<KeyCode> inputList = new ArrayList<>();

    public static void eventHandlers(Scene scene){
        KeyPressHandler keyPressHandler = new KeyPressHandler();
        KeyReleaseHandler keyReleaseHandler = new KeyReleaseHandler();
        scene.setOnKeyPressed(keyPressHandler);
        scene.setOnKeyReleased(keyReleaseHandler);
    }

    public boolean isPressed(KeyCode code){
        if (inputList.contains(code)) {
            return true;
        } else {
            return  false;
        }
    }

    public static List getInputList(){
        return inputList;
    }
}
