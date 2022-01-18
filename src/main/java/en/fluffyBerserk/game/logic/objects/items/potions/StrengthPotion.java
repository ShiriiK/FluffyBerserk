package en.fluffyBerserk.game.logic.objects.items.potions;

import en.fluffyBerserk.game.logic.ObjectType;
import javafx.scene.image.Image;

public class StrengthPotion extends Potion {

    private int strength;

    public StrengthPotion(int strength,ObjectType type) {
        super(type);
        this.strength = strength;
    }


    @Override
    protected void drink() {
        // TODO add strength to user!
    }

    @Override
    public String getName() {
        return "Strength potion";
    }

    @Override
    public Image getImage() {
        return null;
    }
}
