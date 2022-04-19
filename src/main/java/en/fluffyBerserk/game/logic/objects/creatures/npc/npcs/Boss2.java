package en.fluffyBerserk.game.logic.objects.creatures.npc.npcs;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.creatures.npc.MeleeNpc;
import en.fluffyBerserk.gui.utils.LocateImage;

public class Boss2 extends MeleeNpc implements Boss {

    public Boss2() {
        super(new LocateImage("npcs/boss3.png"));
        this.setDmg(10);
        this.setMaxHp(75);
    }

    @Override
    public String getName() {
        return "boss2";
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