package en.fluffyBerserk.logic;

import en.fluffyBerserk.logic.objects.items.Item;
import en.fluffyBerserk.logic.objects.items.PickableItem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class representing the player inventory and implementing the SubjectOfChange interface
 */

public class Inventory {
    private final Map<String, Item> content;

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
        }
    }
}
