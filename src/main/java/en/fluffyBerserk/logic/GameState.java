package en.fluffyBerserk.logic;

import en.fluffyBerserk.gui.utils.Observer;
import en.fluffyBerserk.gui.utils.SubjectOfChange;
import en.fluffyBerserk.logic.objects.creatures.player.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameState implements SubjectOfChange {
    private final Inventory inventory;
    private final Player player;
    private Location currentLocation;
    private int phase;
    private final Set<Observer> observers = new HashSet<>();

    public GameState(){
        createGame();
        player = new Player(null);
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

    public Player getPlayer() {
        return player;
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

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}