package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.gui.utils.LocateImage;

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
}
