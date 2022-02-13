package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.gui.utils.LocateImage;

import java.time.temporal.ValueRange;

public class Boss1 extends MeleeNpc  {


    public Boss1() {
        super(new LocateImage("npcs/boss4.png"));
        this.setDmg(10);
        this.setHp(50);
    }

    @Override
    public String getName() {
        return "boss1";
    }

    @Override
    public int getHeight(){
        return (int) (Constants.TILE_SIZE*1.5);
    }

    @Override
    public int getWidth(){
        return (int) (Constants.TILE_SIZE*1.5);
    }

}
