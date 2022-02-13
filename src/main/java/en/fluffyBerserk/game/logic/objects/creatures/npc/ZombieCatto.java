package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.gui.graphics.sprites.SpritesFactory;

public class ZombieCatto extends MeleeNpc implements HasName {

    public ZombieCatto() {
        super(SpritesFactory.getRandomMeleeEnemySprite());

        this.setDmg(5);
        this.setHp(35);
    }

    @Override
    public String getName() {
        return "ZombieCatto";
    }

}
