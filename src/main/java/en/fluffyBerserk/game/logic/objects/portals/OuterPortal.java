package en.fluffyBerserk.game.logic.objects.portals;

import en.fluffyBerserk.game.animations.SpritesFactory;
import en.fluffyBerserk.gui.utils.LocateImage;

public class OuterPortal extends Portal {

    public OuterPortal(LocateImage sprite) {
        super(SpritesFactory.getObjectSpriteByNumber(1));
    }

    @Override
    public String getName() {
        return "Outer portal";
    }
}
