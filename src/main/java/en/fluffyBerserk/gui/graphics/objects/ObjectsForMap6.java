package en.fluffyBerserk.gui.graphics.objects;

import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.portals.HomePortal;

public class ObjectsForMap6 {

    public static Entity[] loadObjects() {
        Entity object[] = new Entity[1];

        object[0] = new HomePortal();
        object[0].setX(950);
        object[0].setY(1300);


        return object;
    }
}
