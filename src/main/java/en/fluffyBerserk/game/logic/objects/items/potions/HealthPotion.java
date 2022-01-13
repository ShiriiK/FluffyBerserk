package en.fluffyBerserk.game.logic.objects.items.potions;

import javafx.scene.image.Image;

public class HealthPotion extends Potion {

    private int health;

    public HealthPotion(int health) {
        this.health = health;
    }

    @Override
    protected void drink() {
        // TODO add health to user!
    }

    @Override
    public String getName() {
        return "Health potion";
    }

    @Override
    public Image getImage() {
        return null;
    }
}
