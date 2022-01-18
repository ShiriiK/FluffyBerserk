package en.fluffyBerserk.game.logic.objects.portals;

import en.fluffyBerserk.game.logic.Animated;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.portals.destinations.Destination;
import en.fluffyBerserk.gui.graphics.animations.AnimationManager;
import en.fluffyBerserk.gui.graphics.animations.AnimationsFactory;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Portal extends Entity implements HasName, Animated {

    protected final AnimationManager animationManager;
    protected final ArrayList<Image> animations;

    public Portal() {
        super(ObjectType.PORTAL);
        animations = AnimationsFactory.portalAnimations();
        animationManager = new AnimationManager(this);
    }

    private ArrayList<Destination> destinations;

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void goTo(Destination destination) {
        // TODO
    }

    @Override
    public Image getImage() {
        return animationManager.getImage();
    }

    @Override
    public ArrayList<Image> getAnimations() {
        return animations;
    }

    @Override
    public AnimationManager getAnimationManager() {
        return animationManager;
    }
}
