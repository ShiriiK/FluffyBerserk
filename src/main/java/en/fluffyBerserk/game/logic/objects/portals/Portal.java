package en.fluffyBerserk.game.logic.objects.portals;

import en.fluffyBerserk.game.logic.objects.AnimatedEntity;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.portals.destinations.Destination;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Portal extends AnimatedEntity implements HasName {


    private ArrayList<Destination> destinations;

    public Portal() {
        super(ObjectType.PORTAL);
    }

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
}
