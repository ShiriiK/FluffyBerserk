package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

public class Knight extends AggressiveNpc {

    public Knight(LocateImage sprite) {
        super(sprite);
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
