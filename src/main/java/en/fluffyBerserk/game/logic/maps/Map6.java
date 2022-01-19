package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;

import java.util.ArrayList;


public final class Map6 extends Map {
    Entity[] objects = ObjectsForMap.loadObjects(6);
    ArrayList<Entity> entities = EntitiesForMaps.loadMap6();


    @Override
    public String getName() {
        return "map6";
    }

    @Override
    public int getWidth() {
        return 20 * Constants.TILE_SIZE;
    }

    @Override
    public int getHeight() {
        return 20 * Constants.TILE_SIZE;
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
    public ArrayList<Entity> getEntities(){ return entities; }

    @Override
    public int getId() { return 6;}
}

