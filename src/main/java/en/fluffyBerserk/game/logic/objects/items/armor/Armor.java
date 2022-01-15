package en.fluffyBerserk.game.logic.objects.items.armor;

import en.fluffyBerserk.game.logic.objects.items.WearableItem;

public abstract class Armor extends WearableItem {

    public String name;
    public int str;
    public int armor;
    public int stamina;
    public int intelllect;
    public boolean isEquiped;

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

}
