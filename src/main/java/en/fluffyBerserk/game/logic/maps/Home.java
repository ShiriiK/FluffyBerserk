package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.gui.graphics.objects.ObjectsAtHome;
import en.fluffyBerserk.game.logic.objects.Entity;

public class Home extends Map{
    Entity[] objects = ObjectsAtHome.loadObjects();

    @Override
    public String getName() {
        return "map5";
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
    public Entity[] getObjects() {
        return objects;
    }
}
