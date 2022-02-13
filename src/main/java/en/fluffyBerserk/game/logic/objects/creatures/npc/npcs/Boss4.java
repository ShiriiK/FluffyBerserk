package en.fluffyBerserk.game.logic.objects.creatures.npc.npcs;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.creatures.npc.MeleeNpc;
import en.fluffyBerserk.gui.utils.LocateImage;

public class Boss4 extends MeleeNpc {

    public Boss4() {
        super(new LocateImage("npcs/boss5.png"));
        this.setDmg(10);
        this.setHp(50);
    }

    @Override
    public String getName() {
        return "boss5";
    }

    @Override
    public int getHeight() {
        return (int) (Constants.TILE_SIZE * 1.5);
    }

    @Override
    public int getWidth() {
        return (int) (Constants.TILE_SIZE * 1.5);
    }

}