package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;

import java.util.ArrayList;

/**
 * Area1
 */
public final class Map3 extends Map{
    Entity[] objects = ObjectsForMap.loadObjects(3);
    ArrayList<Entity> entities = EntitiesForMaps.loadMap3();

    @Override
    public String getName() {
        return "map3";
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
        return true;
    }

    @Override
    public Entity[] getObjects() {
        return objects;
    }

    @Override
    protected int setPhase() {
        return 1;
    }

    @Override
    public ArrayList<Entity> getEntities(){ return entities; }

    @Override
    public int getId() { return 3;}


}
