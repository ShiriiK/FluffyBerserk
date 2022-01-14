package en.fluffyBerserk.game.logic.objects.portals;

import en.fluffyBerserk.game.animations.AnimationsFactory;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class HomePortal extends Portal {

    @Override
    public String getName() {
        return "Home portal";
    }

    @Override
    protected ArrayList<Image> setAnimations() {
        return AnimationsFactory.portalAnimations();
    }
}

