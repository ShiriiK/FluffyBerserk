package en.fluffyBerserk.game.logic.objects.items;

import javafx.scene.image.Image;

public class Heart extends PickableItem {

    @Override
    public String getName() {
        return "Heart";
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public void pick() {
        // TODO add health to user, don't add it to inventory!!
    }
}
