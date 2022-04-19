package en.fluffyBerserk.game.logic.objects.items.potions;

import en.fluffyBerserk.Main;
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
        Main.app.getGame().getPlayer().resetCooldown();
        Main.app.getGame().getPlayer().getCharacter().setStrength(Main.app.getGame().getPlayer().getCharacter().getStrength()+10);
        Main.app.getGame().getGameLoop().stengthPotionTimer.start();
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
