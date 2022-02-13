package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.bullets.Bullet;
import en.fluffyBerserk.gui.utils.LocateImage;

import java.time.temporal.ValueRange;

public abstract class RangedNpc extends MeleeNpc{

    protected static final long attackRange = 100L;
    protected int attackCd = 100;

    public RangedNpc(LocateImage sprite) {
        super(sprite);
    }

    @Override
    public void move() {
        long moveX = (long) this.getX();
        ValueRange rangeX = ValueRange.of((long) game.getPlayer().getX() - attackRange,(long) game.getPlayer().getX() + attackRange);

        if(rangeX.isValidValue(moveX)){
            this.setMoveX(0F);
        } else if(rangeX.getMaximum() > moveX){
            this.setMoveX(this.getNpcSpeed());
        } else {
            this.setMoveX(- this.getNpcSpeed());
        }

        long moveY = (long) this.getY();
        ValueRange rangeY = ValueRange.of((long) game.getPlayer().getY()- attackRange,(long) game.getPlayer().getY()+ attackRange);

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

    public void shoot() {
        if (attackCd >= 100 && bulletDirection() != 0) {
            Bullet bullet = new Bullet(this.getDmg());
            switch (bulletDirection()) {
                case 1:
                    bullet.setMoveY(-Bullet.SPEED);
                    break;
                case 2:
                    bullet.setMoveX(Bullet.SPEED);
                    break;
                case 3:
                    bullet.setMoveY(Bullet.SPEED);
                    break;
                case 4:
                    bullet.setMoveX(-Bullet.SPEED);
                    break;
            }
            bullet.setX(this.getX() + Constants.ENTITIES_SIZE / 2);
            bullet.setY(this.getY() + Constants.ENTITIES_SIZE / 2);
            game.getEntityManager().getEntities().add(bullet);
            this.attackCd = 0;

        } else {
            attackCd++;
        }
    }

    public int bulletDirection() {
        int direction = 0;
        float diffX = game.getPlayer().getX() - this.getX();
        float diffY = game.getPlayer().getY() - this.getY();
        boolean yCloserThanX = Math.abs(diffX) < Math.abs(diffY);

        if (diffX > attackRange || -diffX < attackRange || diffY > attackRange || -diffY < attackRange) {
            if (diffY < 0 && yCloserThanX) {
                direction = 1;
            } else if (diffX > 0 && !yCloserThanX) {
                direction = 2;
            }
            if (diffY > 0 && yCloserThanX) {
                direction = 3;
            } else if (diffX < 0 && !yCloserThanX) {
                direction = 4;
            }
        }
        return direction;
    }
}
