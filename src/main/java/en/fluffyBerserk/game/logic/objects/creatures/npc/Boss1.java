package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.gui.graphics.sprites.SpritesFactory;
import en.fluffyBerserk.gui.utils.LocateImage;

public class Boss1 extends Creature implements HasName {
    private Game game;

    public Boss1(Game game) {
        super(new LocateImage("npcs/boss4.png"), ObjectType.ENEMY);
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
}
