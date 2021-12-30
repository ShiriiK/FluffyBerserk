package en.fluffyBerserk.logic;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.base.Application;
import en.fluffyBerserk.gui.screens.EditScreen;
import en.fluffyBerserk.gui.utils.Observer;
import en.fluffyBerserk.gui.utils.SubjectOfChange;
import en.fluffyBerserk.logic.objects.creatures.player.Player;
import en.fluffyBerserk.logic.objects.items.Item;
import en.fluffyBerserk.logic.objects.items.PickableItem;
import en.fluffyBerserk.logic.objects.items.WearableItem;
import en.fluffyBerserk.logic.objects.items.armor.Armor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Class representing the player inventory and implementing the SubjectOfChange interface
 */

public class Inventory implements SubjectOfChange {
    private final Map<String, Item> content;
    private final Set<Observer> observers = new HashSet<>();

    // Constructor
    public Inventory() {
        content = new HashMap<>();
    }


    // Returns the content of the inventory
    public Map<String, Item> getContent() {
        return content;
    }

    // Returns the names of items in the inventory
    public Set<String> itemsInInventory() {
        return content.keySet();
    }

    // Inserts the item into the inventory
    public void addItem(Item item) {
        if (item instanceof PickableItem) {
            content.put(item.getName(), item);
            notifyObservers();
        }
    }

    // Equips selected item and applies it's stats
    public void equip(Item item){
        if (item instanceof Armor){
            ((Armor) item).setEquiped(true);
            int str = ((Armor) item).getStr();
            int armor = ((Armor) item).getArmor();
            int stamina = ((Armor) item).getStamina();
            int intellect = ((Armor) item).getIntelllect();

            Player player = GameState.player;
            int newStr = str + player.getStr();

            int newArmor = armor + player.getArmor();
            int newStamina = stamina + player.getStamina();
            int newIntellect = intellect + player.getIntelllect();
            player.setStr(newStr);
            player.setArmor(newArmor);
            player.setStamina(newStamina);
            player.setIntelllect(newIntellect);
        }
    }


    // Return a reference to an item by its name
    public Item getItem(String name) {
        Item item = null;
        if(content.containsKey(name)) {
            item = content.get(name);
        }
        return item;
    }

    //removes the item from inventory
    public void removeItem(String name) {
        if (content.containsKey(name)) {
            content.remove(name);
            notifyObservers();
        }
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
