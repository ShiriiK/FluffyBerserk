package en.fluffyBerserk.objects.portals;

import en.fluffyBerserk.objects.Entity;
import en.fluffyBerserk.objects.HasName;
import en.fluffyBerserk.objects.portals.destinations.Destination;

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
