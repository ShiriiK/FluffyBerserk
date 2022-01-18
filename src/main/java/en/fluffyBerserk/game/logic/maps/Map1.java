package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.graphics.objects.ObjectsForMap;


/**
 * Safe zone
 */
public final class Map1 extends Map {
    String mapName = "map1";
    Entity[] objects = ObjectsForMap.loadObjects(1);

    /*public Map1(int currentMapNumber){
        mapName += "1";
        objects = ObjectsForMap.loadObjects(currentMapNumber);
    } */

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
    public boolean isForCombat() {
        return false;
    }

    @Override
    public Entity[] getObjects() {
        return objects;
    }

}
