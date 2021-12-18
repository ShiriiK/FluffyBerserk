package en.fluffyBerserk.logic.objects.portals;

import en.fluffyBerserk.logic.objects.Entity;
import en.fluffyBerserk.logic.objects.HasName;
import en.fluffyBerserk.logic.objects.portals.destinations.Destination;

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
    public String getImagePath() {
        return ""; // TODO
    }
}
