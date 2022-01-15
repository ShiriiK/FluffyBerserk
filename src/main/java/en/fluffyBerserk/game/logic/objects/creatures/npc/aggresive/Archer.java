package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.game.logic.ObjectType;
import javafx.scene.image.Image;

public class Archer extends AggressiveNpc {

    public Archer(ObjectType type) {
        super(type);
    }

    @Override
    public String getName() {
        return "Archer";
    }

    @Override
    public void move() {

    }

    @Override
    public Image getImage() {
        return null; // TODO
    }
}
