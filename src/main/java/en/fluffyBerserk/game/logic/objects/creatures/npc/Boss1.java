package en.fluffyBerserk.game.logic.objects.creatures.npc;

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
    public String getName() {
        return "boss1";
    }

    @Override
    public void move() {
        float playerX = game.getPlayer().getX();
        float playerY = game.getPlayer().getY();


        if (playerX >= this.getX()) {
            setMoveX(+getNpcSpeed());
        }
        if (playerX < this.getX()) {
            setMoveX(-getNpcSpeed());
        }
        if (playerY >= this.getY()) {
            setMoveY(getNpcSpeed());

        }
        if (playerY < this.getY()) {
            setMoveY(-getNpcSpeed());

        }
        super.move();
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
