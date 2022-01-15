package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.gui.graphics.objects.ObjectsInArea1;
import en.fluffyBerserk.game.logic.objects.AnimatedEntity;

public final class Area1 extends Map{
    AnimatedEntity[] objects = ObjectsInArea1.loadObjects();

    @Override
    public String getName() {
        return "map2";
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
    public AnimatedEntity[] getObjects() {
        return objects;
    }
}
