package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.graphics.objects.ObjectsForMap3;

/**
 * Area1
 */
public final class Map3 extends Map{
    Entity[] objects = ObjectsForMap3.loadObjects();

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
    public boolean isLocked() {
        return false;
    }

    @Override
    public void setLocked(boolean locked) {

    }

    @Override
    public Entity[] getObjects() {
        return objects;
    }
}
