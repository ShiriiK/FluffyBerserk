package en.fluffyBerserk.logic.objects.items.armor;

public class Pants extends Armor{

    public Pants(String name ,int str, int armor, int stamina, int intelllect) {
        super.name = name;
        super.str = str;
        super.armor = armor;
        super.stamina = stamina;
        super.intelllect = intelllect;
        boolean isEquiped = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImagePath() {
        return null;
    }
}
