package en.fluffyBerserk.logic.objects.items.armor;

import en.fluffyBerserk.logic.objects.items.WearableItem;

public class Armor extends WearableItem {

    private int str;
    private int armor;
    private int stamina;
    private int intelllect;
    private boolean isEquiped;
    private String armorType;

    public Armor(int str, int armor, int stamina, int intelllect, boolean isEquiped,String armorType) {

        this.str = str;
        this.armor = armor;
        this.stamina = stamina;
        this.intelllect = intelllect;
        this.isEquiped = isEquiped;
        this.armorType = armorType;
    }


    public void setStr(int str) {
        this.str = str;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setIntelllect(int intelllect) {
        this.intelllect = intelllect;
    }

    public void setEquiped(boolean equiped) {
        isEquiped = equiped;
    }


    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    public int getStr() {
        return str;
    }

    public int getArmor() {
        return armor;
    }

    public int getStamina() {
        return stamina;
    }

    public int getIntelllect() {
        return intelllect;
    }

    public boolean isEquiped() {
        return isEquiped;
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getImagePath() {
        return null;
    }
}
