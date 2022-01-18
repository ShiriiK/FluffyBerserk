package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.graphics.objects.ObjectsForMap;


public final class Map6 extends Map {
    Entity[] objects = ObjectsForMap.loadObjects(6);

    @Override
    public String getName() {
        return "map6";
    }

    @Override
    public int getWidth() {
        return 30 * Constants.TILE_SIZE;
    }

    @Override
    public int getHeight() {
        return 30 * Constants.TILE_SIZE;
    }

    @Override
    public boolean isForCombat() {
        return true;
    }

    @Override
    public Entity[] getObjects() {
        return objects;
    }

    @Override
    public int getId() { return 6;}
}

