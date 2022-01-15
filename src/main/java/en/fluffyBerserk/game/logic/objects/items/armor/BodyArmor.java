package en.fluffyBerserk.game.logic.objects.items.armor;

import javafx.scene.image.Image;

public class BodyArmor extends Armor{

    public BodyArmor(String name ,int str, int armor, int stamina, int intelllect) {
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
    public Image getImage() {
        return null;
    }
}
