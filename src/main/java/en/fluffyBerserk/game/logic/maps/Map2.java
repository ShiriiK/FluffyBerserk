package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.graphics.objects.ObjectsForMap;

/**
 * Home
 */
public class Map2 extends Map{
    Entity[] objects = ObjectsForMap.loadObjects(2);


    @Override
    public String getName() {
        return "map2";
    }

    @Override
    public int getWidth() {
        return Constants.WORLD_WIDTH/2;
    }

    @Override
    public int getHeight() {
        return Constants.WORLD_HEIGHT/2;
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
