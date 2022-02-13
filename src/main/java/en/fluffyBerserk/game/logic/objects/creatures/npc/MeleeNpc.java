package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.utils.LocateImage;

import java.time.temporal.ValueRange;

public abstract class MeleeNpc extends Npc {

    public MeleeNpc(LocateImage sprite) {
        super(sprite);
    }

    @Override
    public void move() {
        long moveX = (long) this.getX();
        ValueRange rangeX = ValueRange.of((long) Main.app.getGame().getPlayer().getX() - 10, (long) Main.app.getGame().getPlayer().getX() + 10);

        if (rangeX.isValidValue(moveX)) {
            this.setMoveX(0F);
        } else if (rangeX.getMaximum() > moveX) {
            this.setMoveX(this.getNpcSpeed());
        } else {
            this.setMoveX(-this.getNpcSpeed());
        }

        long moveY = (long) this.getY();
        ValueRange rangeY = ValueRange.of((long) Main.app.getGame().getPlayer().getY() - 10, (long) Main.app.getGame().getPlayer().getY() + 10);

        if (rangeY.isValidValue(moveY)) {
            setMoveY(0F);
        } else if (rangeY.getMaximum() > moveY) {
            this.setMoveY(this.getNpcSpeed());
        } else {
            this.setMoveY(-this.getNpcSpeed());
        }

        setX(this.getX() + this.getMoveX());
        setY(this.getY() + this.getMoveY());
        this.movableEntityAnimationManager.increaseTick();
    }
}
