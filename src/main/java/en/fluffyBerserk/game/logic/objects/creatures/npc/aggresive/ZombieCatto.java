package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.game.Game;
import en.fluffyBerserk.game.animations.SpritesFactory;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.game.logic.objects.creatures.npc.NpcFactory;

import java.util.Random;

public class ZombieCatto extends Creature implements HasName {
    private Game game;

    public ZombieCatto(Game game) {
        super(SpritesFactory.getSpriteByNumber(new Random().ints(13, 14).findFirst().getAsInt()));
        this.game = game;
        NpcFactory.init(this);
    }

    @Override
    public String getName() {
        return "ZombieCatto";
    }

    @Override
    public void move() {
        //TODO dojebalo se otaceni
        boolean move_left = false;
        boolean move_right = false;
        if (game.getPlayer().getX() > this.getX()) {
            setMoveX(+getNpcSpeed());
            move_right = true;
        }
        if (game.getPlayer().getX() < this.getX()) {
            setMoveX(-getNpcSpeed());
            move_left = true;
        }
        if (game.getPlayer().getY() > this.getY()) {
            if (move_left || move_right) {
                setMoveY(getNpcSpeed());
            }
        }
        if (game.getPlayer().getY() < this.getY()) {
            if (move_left || move_right) {
                setMoveY(-getNpcSpeed());
            }
        }
        super.move();
    }
}
