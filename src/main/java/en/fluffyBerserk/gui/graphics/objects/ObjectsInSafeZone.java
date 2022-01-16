package en.fluffyBerserk.gui.graphics.objects;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.portals.HomePortal;

public class ObjectsInSafeZone {

    public static Entity[] loadObjects() {
        Entity object[] = new Entity[2];

        object[0] = new HomePortal();
        object[0].setX(17 * Constants.TILE_SIZE);
        object[0].setY((float) (6.5 * Constants.TILE_SIZE));

        object[1] = EntityFactory.home;
        object[1].setX(Constants.TILE_SIZE*5);
        object[1].setY(0);

        return object;
    }


}
