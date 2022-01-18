package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.graphics.objects.ObjectsForMap1;


/**
 * Safe zone
 */
public final class Map1 extends Map {

    Entity[] objects = ObjectsForMap1.loadObjects();

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
    public boolean isLocked() {
        return false;
    }

    @Override
    public Entity[] getObjects() {
        return objects;
    }

}
