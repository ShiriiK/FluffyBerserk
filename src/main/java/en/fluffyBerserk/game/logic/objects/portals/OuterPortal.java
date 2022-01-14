package en.fluffyBerserk.game.logic.objects.portals;

import en.fluffyBerserk.game.animations.AnimationsFactory;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class OuterPortal extends Portal {

    @Override
    public String getName() {
        return "Outer portal";
    }

    @Override
    protected ArrayList<Image> setAnimations() {
        return AnimationsFactory.portalAnimations();
    }
}
