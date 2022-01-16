package en.fluffyBerserk.game.logic.objects.items.inventory;


import en.fluffyBerserk.game.logic.objects.items.Item;
import en.fluffyBerserk.game.logic.objects.items.PickableItem;
import en.fluffyBerserk.game.logic.objects.items.armor.Armor;
import en.fluffyBerserk.game.logic.objects.items.armor.BodyArmor;
import en.fluffyBerserk.game.logic.objects.items.armor.Head;
import en.fluffyBerserk.game.logic.objects.items.armor.Pants;
import en.fluffyBerserk.persistence.models.Character;

import java.util.*;


/**
 * Class representing the player inventory
 */

public class Inventory {
    private final Map<String, PickableItem> content;
    private final Character character;
    private int bodyArmorSlot;
    private int headSlot;
    private int pantsSlot;



    // Constructor
    public Inventory(Character character) {
        this.character = character;
        content = new HashMap<>();
        bodyArmorSlot = 0;
        headSlot = 0;
        pantsSlot = 0;

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

            if(item instanceof BodyArmor && bodyArmorSlot == 0){
                bodyArmorSlot = 1;
                applyStats((Armor) item);
            }

            if(item instanceof Head && headSlot == 0){
                headSlot = 1;
                applyStats((Armor) item);
            }

            if(item instanceof Pants && pantsSlot == 0){
                pantsSlot = 1;
                applyStats((Armor) item);
            }
        }
    }

    private void applyStats(Armor item){
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

    //Uneuips selected item and changes player's stats accordingly
    public void unEquip(Item item){
        if (item instanceof Armor && ((Armor) item).isEquiped()){

            if(item instanceof BodyArmor && bodyArmorSlot == 1){
                bodyArmorSlot = 0;
                unapplyStats((Armor) item);
            }

            if(item instanceof Head && headSlot == 1){
                headSlot = 0;
                unapplyStats((Armor) item);
            }

            if(item instanceof Pants && pantsSlot == 1){
                pantsSlot = 0;
                unapplyStats((Armor) item);
            }
        }
    }

    private void unapplyStats(Armor item){
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

    // Return a reference to an item by its name
    public Item getItem(String name) {
        Item item = null;
        if(content.containsKey(name)) {
            item = content.get(name);
        }
        return item;
    }

}

