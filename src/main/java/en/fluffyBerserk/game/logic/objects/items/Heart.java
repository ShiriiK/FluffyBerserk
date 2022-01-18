package en.fluffyBerserk.game.logic.objects.items;

import en.fluffyBerserk.game.logic.ObjectType;
import javafx.scene.image.Image;

public class Heart extends PickableItem {

    public Heart(ObjectType type) {
        super(type);
    }

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
