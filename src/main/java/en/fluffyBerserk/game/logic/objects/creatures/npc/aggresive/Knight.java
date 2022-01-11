package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.gui.utils.LocateImage;

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
}
