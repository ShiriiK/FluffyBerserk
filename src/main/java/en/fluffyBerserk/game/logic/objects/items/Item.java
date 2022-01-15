package en.fluffyBerserk.game.logic.objects.items;

import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.Entity;

public abstract class Item extends Entity implements HasName {
    public Item(ObjectType type) {
        super(type);
    }
}
