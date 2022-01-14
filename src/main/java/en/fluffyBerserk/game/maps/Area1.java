package en.fluffyBerserk.game.maps;

import en.fluffyBerserk.game.graphics.objects.ObjectsInArea1;
import en.fluffyBerserk.game.logic.objects.AnimatedEntity;

public final class Area1 extends Map{
    AnimatedEntity[] objects = ObjectsInArea1.loadObjects();

    @Override
    public String getName() {
        return "map2";
    }

    @Override
    public AnimatedEntity[] getObjects() {
        return objects;
    }
}
