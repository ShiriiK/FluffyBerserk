package en.fluffyBerserk.game.maps;

import en.fluffyBerserk.game.graphics.objects.ObjectsInSafeZone;
import en.fluffyBerserk.game.logic.objects.AnimatedEntity;

public final class SafeZoneMap extends Map {
    AnimatedEntity[] objects = ObjectsInSafeZone.loadObjects();

    @Override
    public String getName() {
        return "map1";
    }


    @Override
    public AnimatedEntity[] getObjects() {
        return objects;
    }

}
