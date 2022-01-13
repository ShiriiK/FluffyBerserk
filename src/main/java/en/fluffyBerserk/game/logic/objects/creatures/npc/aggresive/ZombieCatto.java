package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.Game;
import en.fluffyBerserk.game.animations.SpritesFactory;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;

import java.util.Random;

public class ZombieCatto extends Creature implements HasName {
    private boolean isAlive;
    private Game game;


    public ZombieCatto(Game game) {
        super(SpritesFactory.getSpriteByNumber(new Random().ints(13,14).findFirst().getAsInt()));
        this.isAlive = true;
        init();
        this.game = game;
    }

    public void init() {
        Random rand = new Random();
        int world_upperbound = Constants.WORLD_HEIGHT - 100;
        setY(rand.nextInt(world_upperbound));
        setX(rand.nextInt(world_upperbound));
        setHp(20);
        setStr(5);
        setDmg(getStr() * 2);
        setNpcSpeed(4F);
        setMoveX(getNpcSpeed());
        setMoveY(getNpcSpeed());
    }

    @Override
    public String getName() {
        return "ZombieCatto";
    }

    @Override
    public void move() {
        boolean move_left = false;
        boolean move_right = false;
        if (game.getPlayer().getX() > this.getX()) {
            setMoveX(+ getNpcSpeed());
            setX(this.getX() + getMoveX());
            move_left = true;
        }
        if (game.getPlayer().getX() < this.getX()) {
            setMoveX( - getNpcSpeed());
            setX(this.getX() + getMoveX());
            move_right = true;
        }
        if (game.getPlayer().getY() > this.getY()) {
            if(move_left || move_right){
                setMoveY(getNpcSpeed());
            }
            setY(this.getY() + getMoveY());
        }
        if (game.getPlayer().getY() < this.getY()) {
            if(move_left || move_right){
                setMoveY(-getNpcSpeed());
            }
            setY(this.getY() + getMoveY());
        }
        super.increaseTick();
    }
}
