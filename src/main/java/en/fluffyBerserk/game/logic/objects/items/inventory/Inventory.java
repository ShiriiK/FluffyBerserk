package en.fluffyBerserk.game.logic.objects.items.inventory;


import en.fluffyBerserk.game.logic.objects.creatures.player.Player;
import en.fluffyBerserk.game.logic.objects.items.Item;
import en.fluffyBerserk.game.logic.objects.items.PickableItem;
import en.fluffyBerserk.logic.objects.items.armor.Armor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Class representing the player inventory
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

    // Equips selected item and applies it's stats
    //TODO item slots
    public void equip(Item item){
        if (item instanceof Armor && content.containsValue(item)){
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
        else {
            System.out.println("Something went wrong here");
        }
    }

    //Uneuips selected item and changes player's stats accordingly
    public void unEquip(Item item){
        if (item instanceof Armor && ((Armor) item).isEquiped()){
            ((Armor) item).setEquiped(false);
            Player player = GameState.player;

            int str = ((Armor) item).getStr();
            int armor = ((Armor) item).getArmor();
            int stamina = ((Armor) item).getStamina();
            int intellect = ((Armor) item).getIntelllect();

            int newStr = player.getStr() - str;
            int newArmor = player.getArmor() - armor;
            int newStamina = player.getStamina() - stamina;
            int newIntellect = player.getIntelllect() - intellect;

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
        }
    }

}

