package en.fluffyBerserk.game.logic.objects.creatures.npc.friendly;

import en.fluffyBerserk.game.logic.ObjectType;
import javafx.scene.image.Image;

public class Wizard extends FriendlyNpc {

    public Wizard(ObjectType type) {
        super(type);
    }

    @Override
    public String getName() {
        return "Wizard";
    }

    @Override
    public void interact() {
        // TODO
    }

    @Override
    public Image getImage() {
        return null; // TODO
    }
}
