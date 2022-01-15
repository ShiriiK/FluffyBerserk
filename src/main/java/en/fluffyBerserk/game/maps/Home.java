package en.fluffyBerserk.game.maps;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;

public class Home extends Map{
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
        return null;
    }
}
