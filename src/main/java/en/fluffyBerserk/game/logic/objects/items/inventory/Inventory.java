package en.fluffyBerserk.game.logic.objects.items.inventory;


import en.fluffyBerserk.game.logic.objects.items.potions.Potion;
import en.fluffyBerserk.persistence.models.Character;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Class representing the player inventory
 */

public class Inventory {
    private final Map<String, Potion> content;

    /**
     * private int bodyArmorSlot;
     * private int headSlot;
     * private int pantsSlot;
     */


    // Constructor
    public Inventory(Character character) {
        content = new HashMap<>();
        /**bodyArmorSlot = 0;
         headSlot = 0;
         pantsSlot = 0;*/

    }

    // Returns the content of the inventory
    public Map<String, Potion> getContent() {
        return content;
    }

    // Returns the names of items in the inventory
    public Set<String> itemsInInventory() {
        return content.keySet();
    }

    // Inserts the item into the inventory
    public void addItem(Potion item) {
        content.put(item.getName(), item);
    }

    //removes the item from inventory
    public void removeItem(String name) {
        content.remove(name);
    }

    // Return a reference to an item by its name
    public Potion getItem(String name) {
        Potion item = null;
        if (content.containsKey(name)) {
            item = content.get(name);
        }
        return item;
    }

}

