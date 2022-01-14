package en.fluffyBerserk.game.maps;

import en.fluffyBerserk.game.graphics.objects.ObjectLoader;
import en.fluffyBerserk.game.logic.AnimatedEntity;

public final class SafeZoneMap extends Map {
    AnimatedEntity[] objects = ObjectLoader.loadObjectsInSafeZone();

    @Override
    public String getName() {
        return "map1";
    }


    @Override
    public AnimatedEntity[] getObjects() {
        return objects;
    }

}
