package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;


import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.bullets.Bullet;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.game.logic.objects.creatures.npc.NpcFactory;
import en.fluffyBerserk.gui.graphics.sprites.SpritesFactory;

public class ArcherCatto extends Creature implements HasName {
    private Game game;
    private static final float attackRange = 5F;
    private int attackCd = 100;

    public ArcherCatto(Game game) {
        super(SpritesFactory.getRandomRangedEnemySprite(), ObjectType.ENEMY);
        this.game = game;
        this.setDmg(10);
        this.setHp(20);
        NpcFactory.init(this);
    }

    @Override
    public String getName() {
        return "ArcherCatto";
    }

    @Override
    public void move() {
        //TODO
        boolean move_left = false;
        boolean move_right = false;

        if (game.getPlayer().getX() - this.getX() > attackRange || this.getX() - game.getPlayer().getX() < attackRange) {
            if (game.getPlayer().getX() > this.getX()) {
                setMoveX(+getNpcSpeed());
                setX(this.getX() + getMoveX());
                move_left = true;
            }
            if (game.getPlayer().getX() < this.getX()) {
                setMoveX(-getNpcSpeed());
                setX(this.getX() + getMoveX());
                move_right = true;
            }
        }

        if (game.getPlayer().getY() - this.getY() > attackRange || this.getY() - game.getPlayer().getY() < attackRange) {
            if (game.getPlayer().getY() > this.getY()) {
                if (move_left || move_right) {
                    setMoveY(getNpcSpeed());
                }
                setY(this.getY() + getMoveY());
            }
            if (game.getPlayer().getY() < this.getY()) {
                if (move_left || move_right) {
                    setMoveY(-getNpcSpeed());
                }
                setY(this.getY() + getMoveY());
            }
        }
    }

    public void shoot() {
        if(attackCd >= 100 && bulletDirection() != 0) {
            Bullet bullet = new Bullet(this.getDmg());
            switch(bulletDirection()){
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
            bullet.setX(this.getX() + Constants.ENTITIES_SIZE/2);
            bullet.setY(this.getY() + Constants.ENTITIES_SIZE/2);
            game.getEntityManager().getEntities().add(bullet);
            this.attackCd = 0;

        } else {attackCd++;}
    }

    private int bulletDirection() {
        int direction = 0;
        float diffX = game.getPlayer().getX() - this.getX();
        float diffY = game.getPlayer().getY() - this.getY();
        boolean yCloserThanX = Math.abs(diffX) < Math.abs(diffY);

        if (diffX > attackRange || -diffX < attackRange || diffY > attackRange || -diffY < attackRange) {
            if (diffY < 0 && yCloserThanX) {direction = 1;}
            else if (diffX > 0 && !yCloserThanX) {direction = 2;}
            if (diffY > 0 && yCloserThanX) {direction = 3;}
            else if (diffX < 0 && !yCloserThanX) {direction = 4;}
        }
        return direction;
    }

}
