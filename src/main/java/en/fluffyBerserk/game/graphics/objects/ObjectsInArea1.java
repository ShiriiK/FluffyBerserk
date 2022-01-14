package en.fluffyBerserk.game.graphics.objects;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.logic.AnimatedEntity;
import en.fluffyBerserk.game.logic.objects.portals.HomePortal;

public class ObjectsInArea1 {

    public static AnimatedEntity[] loadObjects() {
        AnimatedEntity objects[] = new AnimatedEntity[1];

        objects[0] = new HomePortal() {
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
        objects[0].setX(18 * Constants.TILE_SIZE);
        objects[0].setY((float) (6.25 * Constants.TILE_SIZE));

        return objects;
    }
}
