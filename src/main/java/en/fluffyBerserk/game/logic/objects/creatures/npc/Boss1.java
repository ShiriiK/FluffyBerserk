package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.gui.utils.LocateImage;

public class Boss1 extends Creature implements HasName {
    private Game game;
    private int attackCd = 50;

    public Boss1(Game game) {
        super(new LocateImage("npcs/boss4.png"), ObjectType.ENEMY);
        this.game = game;
        this.setDmg(5);
        this.setHp(35);
        NpcFactory.init(this);
    }

    @Override
    public int getHeight(){
        return (int) (Constants.TILE_SIZE*1.5);
    }

    @Override
    public int getWidth(){
        return (int) (Constants.TILE_SIZE*1.5);
    }

    @Override
    public String getName() {
        return "boss1";
    }

    @Override
    public void move() {
        if (game.getPlayer().getX() > this.getX()) {
            setMoveX(+getNpcSpeed());
        }
        else if (this.getX() >= game.getPlayer().getX()) {
            setMoveX(-getNpcSpeed());
        }

        if (game.getPlayer().getY() > this.getY()) {
            setMoveY(getNpcSpeed());
        }
        else if (this.getY() >= game.getPlayer().getY()) {
            setMoveY(-getNpcSpeed());
        }

        setX(this.getX() + getMoveX());
        setY(this.getY() + getMoveY());
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
