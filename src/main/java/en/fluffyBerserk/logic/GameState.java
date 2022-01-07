package en.fluffyBerserk.logic;

import en.fluffyBerserk.gui.utils.Observer;
import en.fluffyBerserk.gui.utils.SubjectOfChange;
import en.fluffyBerserk.logic.objects.creatures.player.Player;
import en.fluffyBerserk.logic.objects.items.armor.Armor;
import en.fluffyBerserk.logic.objects.items.armor.BodyArmor;
import en.fluffyBerserk.logic.objects.items.armor.Pants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameState implements SubjectOfChange {
    private final Inventory inventory;
    public static Player player;
    private Location currentLocation;
    private int phase;
    private final Set<Observer> observers = new HashSet<>();
    private final String[] armorType = {"boots", "pants", "body", "head"};

    public GameState(){
        player = new Player(null);
        inventory = new Inventory();
        phase = 1;
        createGame();
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

        //For testing
//        Armor head = new Armor(7,4,2,3,false,armorType[3]);
//        Armor boots = new Armor(1,2,3,6,false,armorType[0]);
//        Armor body = new Armor(8,6,9,6,false,armorType[2]);
        BodyArmor bodyArmor = new BodyArmor("dgfdsg",7,4,2,3);
        Pants pants = new Pants("ssfgs",1,2,3,4);

        inventory.addItem(pants);
        inventory.equip(pants);
        inventory.addItem(bodyArmor);
        inventory.equip(bodyArmor);

        System.out.println(player.getStr());//28
        inventory.unEquip(bodyArmor);
        System.out.println(player.getStr());//21


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
