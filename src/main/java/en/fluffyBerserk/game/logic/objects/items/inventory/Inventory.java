package en.fluffyBerserk.game.logic.objects.items.inventory;


import en.fluffyBerserk.game.logic.objects.items.Item;
import en.fluffyBerserk.game.logic.objects.items.PickableItem;
import en.fluffyBerserk.game.logic.objects.items.armor.Armor;
import en.fluffyBerserk.persistence.models.Character;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Class representing the player inventory
 */

public class Inventory {
    private final Map<String, PickableItem> content;

    private final Character character;


    // Constructor
    public Inventory(Character character) {
        this.character = character;
        content = new HashMap<>();
    }


    // Returns the content of the inventory
    public Map<String, PickableItem> getContent() {
        return content;
    }

    // Returns the names of items in the inventory
    public Set<String> itemsInInventory() {
        return content.keySet();
    }

    // Inserts the item into the inventory
    public void addItem(PickableItem item) {
            content.put(item.getName(), item);
    }

    //removes the item from inventory
    public void removeItem(String name) {
        content.remove(name);
    }

    // Equips selected item and applies it's stats
    public void equip (Item item){
        if (item instanceof Armor && content.containsValue(item) && !((Armor) item).isEquiped){
            ((Armor) item).setEquiped(true);

            int str = ((Armor) item).getStr();
            int armor = ((Armor) item).getArmor();
            int stamina = ((Armor) item).getStamina();
            int intellect = ((Armor) item).getIntelllect();

            int newStr = str + character.getStrength();
            int newArmor = armor + character.getArmor();
            int newStamina = stamina + character.getStamina();
            int newIntellect = intellect + character.getIntellect();

            character.setStrength(newStr);
            character.setArmor(newArmor);
            character.setStamina(newStamina);
            character.setIntellect(newIntellect);
        }
        else {
            System.out.println("Something went wrong here");
        }
    }

    //Uneuips selected item and changes player's stats accordingly
    public void unEquip(Item item){
        if (item instanceof Armor && ((Armor) item).isEquiped()){
            ((Armor) item).setEquiped(false);
            int str = ((Armor) item).getStr();
            int armor = ((Armor) item).getArmor();
            int stamina = ((Armor) item).getStamina();
            int intellect = ((Armor) item).getIntelllect();

            int newStr = character.getStrength() - str;
            int newArmor = character.getArmor() - armor;
            int newStamina = character.getStamina() - stamina;
            int newIntellect = character.getIntellect() - intellect;

            character.setStrength(newStr);
            character.setArmor(newArmor);
            character.setStamina(newStamina);
            character.setIntellect(newIntellect);
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

}

