package en.fluffyBerserk.game.logic.objects.creatures.npc.friendly;

import en.fluffyBerserk.game.logic.ObjectType;
import javafx.scene.image.Image;

public class QuestGiver extends FriendlyNpc {

    public QuestGiver(ObjectType type) {
        super(type);
    }

    @Override
    public String getName() {
        return "Quest giver";
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
