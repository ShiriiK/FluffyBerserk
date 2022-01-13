package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

public class Archer extends AggressiveNpc {

    public Archer(LocateImage sprite) {
        super(sprite);
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
