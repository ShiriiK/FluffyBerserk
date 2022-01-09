package en.fluffyBerserk.logic;

import java.util.Arrays;

public class GameState  {
    private final Inventory inventory;
    private Location currentLocation;
    private int phase;


    public GameState(){
        createGame();
        inventory = new Inventory();
        phase = 1;
    }

    public void createGame(){
        Location safeLocation = new Location("Safe Location", 1);
        Location endlessModeLocation = new Location("Endless Mode Location", 1);
        Location level1 = new Location("Level 1", 1);
        Location level2 = new Location("Level 2", 2);
        Location level3 = new Location("Level 3", 3);

        currentLocation = safeLocation;

        safeLocation.addExits(Arrays.asList(endlessModeLocation,level1,level2, level3));
        endlessModeLocation.addExits(Arrays.asList(safeLocation, level1, level2, level3));
        level1.addExits(Arrays.asList(safeLocation, endlessModeLocation, level2, level3));
        level2.addExits(Arrays.asList(safeLocation, endlessModeLocation, level1, level3));
        level3.addExits(Arrays.asList(safeLocation, endlessModeLocation, level1, level2));
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }
}
