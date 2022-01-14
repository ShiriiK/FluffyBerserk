package en.fluffyBerserk.game.logic.objects.portals;

import en.fluffyBerserk.game.animations.SpritesFactory;

public class HomePortal extends Portal {


    public HomePortal() {
        super(SpritesFactory.getObjectSpriteByNumber(0));
    }

    @Override
    public String getName() {
        return "Home portal";
    }


}
