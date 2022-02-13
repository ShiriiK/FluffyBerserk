package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.gui.graphics.sprites.SpritesFactory;

public class ArcherCatto extends RangedNpc {

    public ArcherCatto() {
        super(SpritesFactory.getRandomRangedEnemySprite());
        this.setDmg(10);
        this.setHp(20);
    }

    @Override
    public String getName() {
        return "ArcherCatto";
    }
}
