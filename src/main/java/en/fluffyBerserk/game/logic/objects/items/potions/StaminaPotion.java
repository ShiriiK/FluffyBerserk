package en.fluffyBerserk.game.logic.objects.items.potions;

import en.fluffyBerserk.game.logic.ObjectType;
import javafx.scene.image.Image;

public class StaminaPotion extends Potion{

    public StaminaPotion() {
        super(ObjectType.STAMINA_POTION);
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
        return "stamina";
    }

    @Override
    public Image getImage() {
        return new Image("items/health.png");
    }
}
