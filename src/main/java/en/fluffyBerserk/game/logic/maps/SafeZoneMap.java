package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.graphics.objects.ObjectsInSafeZone;

public final class SafeZoneMap extends Map {
    Entity[] objects = ObjectsInSafeZone.loadObjects();

    @Override
    public String getName() {
        return "map1";
    }

    @Override
    public int getWidth() {
        return Constants.WORLD_WIDTH;
    }

    @Override
    public int getHeight() {
        return Constants.WORLD_HEIGHT;
    }

    @Override
    public Entity[] getObjects() {
        return objects;
    }

}
