package en.fluffyBerserk.logic.objects.creatures.npc.friendly;

import en.fluffyBerserk.logic.objects.Entity;
import en.fluffyBerserk.logic.objects.HasName;

public abstract class FriendlyNpc extends Entity implements HasName {

    public abstract void interact();
}
