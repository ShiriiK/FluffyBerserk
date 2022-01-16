package en.fluffyBerserk.gui.graphics.objects;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.AnimatedEntity;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.portals.HomePortal;

public class ObjectsOnMap2 {

    public static Entity[] loadObjects() {
        Entity object[] = new Entity[5];

        object[0] = new HomePortal();
        object[0].setX(3 * Constants.TILE_SIZE);
        object[0].setY((float) (15 * Constants.TILE_SIZE));

        object[1] = EntityFactory.catStatueFront;
        object[1].setX(7 * Constants.TILE_SIZE);
        object[1].setY((float) (11.5 * Constants.TILE_SIZE));

        object[2] = EntityFactory.catStatueRight;
        object[2].setX(3 * Constants.TILE_SIZE);
        object[2].setY((float) (6.5 * Constants.TILE_SIZE));

        object[3] = EntityFactory.catStatueBack;
        object[3].setX(9 * Constants.TILE_SIZE);
        object[3].setY((float) (5.5 * Constants.TILE_SIZE));

        object[4] = EntityFactory.catStatueLeft;
        object[4].setX(17 * Constants.TILE_SIZE);
        object[4].setY((float) (7.5 * Constants.TILE_SIZE));

        return object;
    }
}
