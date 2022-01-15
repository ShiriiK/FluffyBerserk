package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.game.logic.ObjectType;
import javafx.scene.image.Image;

public class Knight extends AggressiveNpc {

    public Knight(ObjectType type) {
        super(type);
    }

    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public void move() {

    }

    @Override
    public Image getImage() {
        return null; // TODO
    }
}
