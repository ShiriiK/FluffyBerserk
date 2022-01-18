package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.graphics.objects.ObjectsForMap;

import java.util.ArrayList;


/**
 * Safe zone
 */
public final class Map1 extends Map {
    Entity[] objects = ObjectsForMap.loadObjects(1);
    ArrayList<Entity> entities = EntitiesForMaps.loadMap1();

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

    @Override
    public ArrayList<Entity> getEntities(){ return entities; }

    @Override
    public int getId() { return 1;}



}
