package en.fluffyBerserk.game.maps;

import en.fluffyBerserk.game.graphics.objects.ObjectsInSafeZone;
import en.fluffyBerserk.game.logic.objects.AnimatedEntity;
import en.fluffyBerserk.game.logic.objects.Entity;

public final class SafeZoneMap extends Map {
    Entity[] objects = ObjectsInSafeZone.loadObjects();

    @Override
    public String getName() {
        return "map1";
    }


    @Override
    public Entity[] getObjects() {
        return objects;
    }

}
