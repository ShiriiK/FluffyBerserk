package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;

import java.util.ArrayList;

/**
 * Home
 */
public class Map2 extends Map{
    Entity[] objects = ObjectsForMap.loadObjects(2);
    ArrayList<Entity> entities = EntitiesForMaps.loadMap2();


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
    public int getId() { return 2;}
}
