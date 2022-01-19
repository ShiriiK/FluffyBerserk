package en.fluffyBerserk.game.logic.objects.items.potions;

import en.fluffyBerserk.game.logic.ObjectType;
import javafx.scene.image.Image;

public class StrengthPotion extends Potion {

    public StrengthPotion() {
        super(ObjectType.STRENGTH_POTION);
    }

    @Override
    protected int setEffect() {
        return 10;
    }


    @Override
    protected void drink() {
        // TODO add health to user!
    }

    @Override
    public String getName() {
        return "strength";
    }

    @Override
    public Image getImage() {
        return new Image("items/strength.png");
    }
}
