package en.fluffyBerserk.game.logic.objects.items.potions;

import en.fluffyBerserk.Main;
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
        Main.app.getGame().getPlayer().resetCooldown();
        Main.app.getGame().getPlayer().setMaxCd(10);
        System.out.println("max cd set to " + Main.app.getGame().getPlayer().getMaxCd());
        Main.app.getGame().getGameLoop().staminaPotionTimer.start();
    }

    @Override
    public String getName() {
        return "stamina";
    }

    @Override
    public Image getImage() {
        return new Image("items/stamina.png");
    }
}
