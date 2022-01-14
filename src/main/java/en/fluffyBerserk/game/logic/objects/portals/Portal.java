package en.fluffyBerserk.game.logic.objects.portals;

import en.fluffyBerserk.game.animations.AnimationManager;
import en.fluffyBerserk.game.logic.AnimatedEntity;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.portals.destinations.Destination;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Portal extends AnimatedEntity implements HasName {

    private ArrayList<Destination> destinations;

    public Portal(LocateImage sprite) {
        super(sprite);
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void goTo(Destination destination) {
        // TODO
    }

    @Override
    public Image getImage() {
        return animationManager.getImage(); // TODO
    }

    public AnimationManager getAnimationManager;
}
