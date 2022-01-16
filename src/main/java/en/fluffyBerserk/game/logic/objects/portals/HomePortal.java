package en.fluffyBerserk.game.logic.objects.portals;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.gui.graphics.animations.AnimationsFactory;
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

    @Override
    public int getHeight() {
        return Constants.TILE_SIZE * 2;
    }

    @Override
    public int getWidth() {
        return Constants.TILE_SIZE;
    }
}

