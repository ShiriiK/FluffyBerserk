package en.fluffyBerserk.game.logic.objects.creatures.npc.npcs;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.creatures.npc.MeleeNpc;
import en.fluffyBerserk.gui.utils.LocateImage;

public class Boss3 extends MeleeNpc implements Boss {

    public Boss3() {
        super(new LocateImage("npcs/boss1.png"));
        this.setDmg(10);
        this.setMaxHp(100);
    }

    @Override
    public String getName() {
        return "boss3";
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
