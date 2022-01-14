package en.fluffyBerserk.game.graphics.objects;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.logic.AnimatedEntity;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.portals.HomePortal;

public class ObjectLoader {

    public static AnimatedEntity[] loadObjectsInSafeZone(){
        AnimatedEntity objects[] = new AnimatedEntity[1];

        objects[0] = new HomePortal() {
            @Override
            public int getHeight(){
                return Constants.ENTITIES_SIZE*3;
            }
            @Override
            public int getWidth(){
                return Constants.ENTITIES_SIZE*5;
            }
        };
        objects[0].setX(32* Constants.BASE_TILE_SIZE);
        objects[0].setY(12* Constants.BASE_TILE_SIZE);

        return objects;
    }
}
