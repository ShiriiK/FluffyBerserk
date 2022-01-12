package en.fluffyBerserk.game.logic.objects.items.potions;

import javafx.scene.image.Image;

public class StrengthPotion extends Potion {

    private int strength;

    public StrengthPotion(int strength) {
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
