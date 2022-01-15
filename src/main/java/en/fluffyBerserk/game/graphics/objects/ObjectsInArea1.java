package en.fluffyBerserk.game.graphics.objects;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.logic.objects.AnimatedEntity;
import en.fluffyBerserk.game.logic.objects.portals.HomePortal;

public class ObjectsInArea1 {

    public static AnimatedEntity[] loadObjects() {
        AnimatedEntity object[] = new AnimatedEntity[1];

        object[0] = new HomePortal() {
            @Override
            public int getHeight() {
                return Constants.TILE_SIZE * 2;
            }

            @Override
            public int getWidth() {
                return Constants.TILE_SIZE;
            }

            @Override
            public int getHitBoxHeight() {
                return getHeight();
            }

            @Override
            public int getHitBoxWidth() {
                return getWidth();
            }
        };
        object[0].setX(17 * Constants.TILE_SIZE);
        object[0].setY((float) (6.5 * Constants.TILE_SIZE));

        return object;
    }
}
