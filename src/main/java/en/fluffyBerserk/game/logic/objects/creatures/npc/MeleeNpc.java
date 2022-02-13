package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.gui.utils.LocateImage;

import java.time.temporal.ValueRange;

public abstract class MeleeNpc extends Creature implements HasName{
    protected Game game = Main.app.getGame();
    protected int attackCd = 50;

    public MeleeNpc(LocateImage sprite) {
        super(sprite, ObjectType.ENEMY);
        this.setNpcSpeed(2F);
    }

    @Override
    public void move() {
        long moveX = (long) this.getX();
        ValueRange rangeX = ValueRange.of((long) game.getPlayer().getX()-10,(long) game.getPlayer().getX()+10);

        if(rangeX.isValidValue(moveX)){
            this.setMoveX(0F);
        } else if(rangeX.getMaximum() > moveX){
            this.setMoveX(this.getNpcSpeed());
        } else {
            this.setMoveX(- this.getNpcSpeed());
        }

        long moveY = (long) this.getY();
        ValueRange rangeY = ValueRange.of((long) game.getPlayer().getY()-10,(long) game.getPlayer().getY()+10);

        if(rangeY.isValidValue(moveY)){
            setMoveY(0F);
        } else if(rangeY.getMaximum() > moveY){
            this.setMoveY(this.getNpcSpeed());
        } else {
            this.setMoveY(- this.getNpcSpeed());
        }

        setX(this.getX() + this.getMoveX());
        setY(this.getY() + this.getMoveY());
        this.movableEntityAnimationManager.increaseTick();
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
