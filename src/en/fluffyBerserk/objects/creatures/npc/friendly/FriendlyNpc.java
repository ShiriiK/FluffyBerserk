package en.fluffyBerserk.objects.creatures.npc.friendly;

import en.fluffyBerserk.objects.Entity;
import en.fluffyBerserk.objects.HasName;

public abstract class FriendlyNpc extends Entity implements HasName {

    public abstract void interact();
}
