package en.fluffyBerserk.game.logic.objects.items.potions;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.logic.ObjectType;
import javafx.scene.image.Image;

public class HealthPotion extends Potion {

    public HealthPotion() {
        super(ObjectType.HEALTH_POTION);
    }

    @Override
    protected int setEffect() {
        return 10;
    }

    @Override
    protected void drink() {
        Main.app.getGame().getPlayer().setHp(20);
    }

    @Override
    public String getName() {
        return "health";
    }

    @Override
    public Image getImage() {
        return new Image("items/health.png");
    }

}
