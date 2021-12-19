package en.fluffyBerserk.gui.gamecontroller;



import en.fluffyBerserk.invariables.Direction;
import en.fluffyBerserk.logic.objects.creatures.player.Player;
import javafx.scene.input.KeyCode;

import java.util.List;

public class InputController {

    public void handleActions(Player player){
        List inputs = EventHandler.getInputList();

        if(inputs.contains(KeyCode.UP) || inputs.contains(KeyCode.W)){
            player.move(5, Direction.UP);
        }
        if(inputs.contains(KeyCode.DOWN) || inputs.contains(KeyCode.S)){
            player.move(5,Direction.DOWN);
        }
        if(inputs.contains(KeyCode.LEFT) || inputs.contains(KeyCode.A)){
            player.move(5,Direction.LEFT);
        }
        if(inputs.contains(KeyCode.RIGHT) || inputs.contains(KeyCode.D)){
            player.move(5,Direction.RIGHT);
        }
        if( !inputs.contains(KeyCode.LEFT) &&
                !inputs.contains(KeyCode.RIGHT) &&
                !inputs.contains(KeyCode.UP) &&
                !inputs.contains(KeyCode.DOWN) &&
                !inputs.contains(KeyCode.W) &&
                !inputs.contains(KeyCode.A) &&
                !inputs.contains(KeyCode.S) &&
                !inputs.contains(KeyCode.D)
        )
        {
            player.move(0, Direction.DOWN);
        }

    }
}
