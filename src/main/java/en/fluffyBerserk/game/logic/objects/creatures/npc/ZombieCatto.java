package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.game.logic.objects.creatures.npc.NpcFactory;
import en.fluffyBerserk.gui.graphics.sprites.SpritesFactory;

import java.util.Random;

public class ZombieCatto extends Creature implements HasName {
    private Game game;
    private int attackCd = 50;

    public ZombieCatto(Game game) {
        super(SpritesFactory.getRandomMeleeEnemySprite(), ObjectType.ENEMY);
        this.game = game;
        this.setDmg(5);
        this.setHp(35);
        NpcFactory.init(this);
    }

    @Override
    public String getName() {
        return "ZombieCatto";
    }

    @Override
    public void move() {
        if (game.getPlayer().getX() > this.getX()) {
            setMoveX(+getNpcSpeed());
        }
        else if (this.getX() > game.getPlayer().getX()) {
            setMoveX(-getNpcSpeed());
        }

        if (game.getPlayer().getY() > this.getY()) {
            setMoveY(getNpcSpeed());
        }
        else if (this.getY() > game.getPlayer().getY()) {
            setMoveY(-getNpcSpeed());
        }

        setX(this.getX() + getMoveX());
        setY(this.getY() + getMoveY());
    }

    public boolean canAttack() {return attackCd == 50;}

    public void resetCd() {attackCd = 0;}

    public void refreshCd() {if (attackCd < 50) attackCd++;}
}
