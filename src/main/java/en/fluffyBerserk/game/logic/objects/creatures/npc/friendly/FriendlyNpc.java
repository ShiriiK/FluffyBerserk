package en.fluffyBerserk.game.logic.objects.creatures.npc.friendly;


import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.objects.Entity;

public abstract class FriendlyNpc extends Entity implements HasName {

    public abstract void interact();
}
