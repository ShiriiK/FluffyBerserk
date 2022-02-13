package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.gui.utils.LocateImage;

public class Boss2 extends MeleeNpc {

    public Boss2(Game game) {
        super(new LocateImage("npcs/boss3.png"));
        this.game = game;
        this.setDmg(10);
        this.setHp(50);
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