package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.Game;
import en.fluffyBerserk.game.animations.SpritesFactory;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;

import java.util.Random;

public class ZombieArcher extends Creature implements HasName {
    private boolean isAlive;
    private Game game;
    private static final float attack_range = 10F;

    public ZombieArcher(Game game) {
        super(SpritesFactory.getSpriteByNumber(15));
        this.isAlive = true;
        this.game = game;
        init();
    }

    @Override
    public String getName() {
        return "ZombieArcher";
    }

    public void init() {
        Random rand = new Random();
        int world_upperbound = Constants.WORLD_HEIGHT - 100;
        setY(rand.nextInt(world_upperbound));
        setX(rand.nextInt(world_upperbound));
        setHp(20);
        setStr(5);
        setNpcSpeed(3F);
        setMoveX(getNpcSpeed());
        setMoveY(getNpcSpeed());
    }

    @Override
    public void move() {
        boolean move_left = false;
        boolean move_right = false;

        if(game.getPlayer().getX() - this.getX() > attack_range || this.getX() - game.getPlayer().getX() < attack_range){
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

        if(game.getPlayer().getY() - this.getY() > attack_range || this.getY() - game.getPlayer().getY() < attack_range){
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
        super.increaseTick();
    }
}
