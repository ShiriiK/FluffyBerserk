package en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;
import en.fluffyBerserk.gui.utils.LocateImage;

public abstract class AggressiveNpc extends Creature implements HasName {
    public AggressiveNpc(LocateImage sprite) {
        super(sprite);
    }
}
