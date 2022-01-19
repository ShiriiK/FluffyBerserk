package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.game.logic.objects.creatures.npc.NpcFactory;
import en.fluffyBerserk.gui.graphics.sprites.SpritesFactory;

import java.util.Random;

public class ZombieCatto extends Creature implements HasName {
    private Game game;

    public ZombieCatto(Game game) {
        super(SpritesFactory.getRandomMeleeEnemySprite(), ObjectType.ENEMY);
        this.game = game;
        this.setDmg(5);
        this.setHp(45);
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
