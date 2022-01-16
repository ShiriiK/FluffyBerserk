package en.fluffyBerserk.gui.graphics.objects;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;

public class ObjectsAtHome {

    public static Entity[] loadObjects() {
        Entity object[] = new Entity[2];

        object[0] = EntityFactory.carpet;
        object[0].setX((float) (4.5 * Constants.TILE_SIZE));
        object[0].setY((float) (8.5 * Constants.TILE_SIZE));

        object[1] = EntityFactory.bed;
        object[1].setX((float) (8 * Constants.TILE_SIZE));
        object[1].setY((float) (2 * Constants.TILE_SIZE));


        return object;
    }
}
