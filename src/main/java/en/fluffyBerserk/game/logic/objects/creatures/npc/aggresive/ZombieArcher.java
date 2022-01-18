package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;


import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.bullets.Bullet;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.game.logic.objects.creatures.npc.NpcFactory;
import en.fluffyBerserk.gui.graphics.sprites.SpritesFactory;

public class ZombieArcher extends Creature implements HasName {
    private Game game;
    private static final float attackRange = 10F;

    public ZombieArcher() {
        super(SpritesFactory.getSpriteByNumber(15), ObjectType.ENEMY);
        NpcFactory.init(this);
    }

    @Override
    public String getName() {
        return "ZombieArcher";
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
        //TODO every now and then shoot at the player kekw
        new Bullet();
    }

    private Bullet newBullet() {
        int direction = 4;
        if (game.getPlayer().getX() - this.getX() > attackRange || this.getX() - game.getPlayer().getX() < attackRange) {
            if (game.getPlayer().getX() > this.getX()) {
                direction = 1;
            }
            if (game.getPlayer().getX() < this.getX()) {
                direction = 4;
            }

            if (game.getPlayer().getY() > this.getY()) {
                direction = 7;
            }
            if (game.getPlayer().getY() < this.getY()) {
                direction = 8;
            }
        }
        return new Bullet();
    }

}
