package en.fluffyBerserk.gui.graphics.objects;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.AnimatedEntity;
import en.fluffyBerserk.game.logic.objects.portals.HomePortal;

public class ObjectsInArea1 {

    public static AnimatedEntity[] loadObjects() {
        AnimatedEntity object[] = new AnimatedEntity[1];

        object[0] = new HomePortal();
        object[0].setX(17 * Constants.TILE_SIZE);
        object[0].setY((float) (6.5 * Constants.TILE_SIZE));

        return object;
    }
}
