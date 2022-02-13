package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.gui.utils.LocateImage;

public class Boss3 extends MeleeNpc {

    public Boss3() {
        super(new LocateImage("npcs/boss1.png"));
        this.setDmg(10);
        this.setHp(50);
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
