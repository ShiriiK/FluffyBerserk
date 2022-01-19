package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.gui.utils.LocateImage;

public class Boss3 extends Creature implements HasName {
    private Game game;
    private int attackCd = 50;

    public Boss3(Game game) {
        super(new LocateImage("npcs/boss1.png"), ObjectType.ENEMY);
        this.game = game;
        this.setDmg(5);
        this.setHp(35);
        NpcFactory.init(this);
    }

    @Override
    public String getName() {
        return "boss3";
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
    public void move() {
        float playerX = game.getPlayer().getX();
        float playerY = game.getPlayer().getY();
        boolean move_left = false;
        boolean move_right = false;


        if (playerX >= this.getX()) {
            setMoveX(+getNpcSpeed());
            setX(this.getX() + getMoveX());
            move_left = true;
        }
        if (playerX < this.getX()) {
            setMoveX(-getNpcSpeed());
            setX(this.getX() + getMoveX());
            move_right = true;
        }
        if (playerY >= this.getY()) {
            if (!move_left || !move_right) {
                setMoveY(getNpcSpeed());
            }
            setY(this.getY() + getMoveY());
        }
        if (playerY < this.getY()) {
            if (!move_left || !move_right) {
                setMoveY(-getNpcSpeed());
            }
            setY(this.getY() + getMoveY());
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
