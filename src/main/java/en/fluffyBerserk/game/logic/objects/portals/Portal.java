package en.fluffyBerserk.game.logic.objects.portals;

import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.portals.destinations.Destination;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Portal extends Entity implements HasName {

    private ArrayList<Destination> destinations;

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void goTo(Destination destination) {
        // TODO
    }

    @Override
    public Image getImage() {
        return null; // TODO
    }
}
