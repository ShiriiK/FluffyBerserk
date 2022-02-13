package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.gui.utils.LocateImage;

public abstract class Npc extends Creature implements HasName{
    protected int attackCd = 50;

    public Npc(LocateImage sprite) {
        super(sprite, ObjectType.ENEMY);
        this.setNpcSpeed(2F);
    }

    public boolean canAttack() {
        return attackCd == 50;
    }

    public void resetCd() {
        attackCd = 0;
    }

    public void refreshCd() {
        if (attackCd < 50) attackCd++;
    }
}
