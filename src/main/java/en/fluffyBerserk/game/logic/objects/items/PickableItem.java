package en.fluffyBerserk.game.logic.objects.items;

import en.fluffyBerserk.game.logic.ObjectType;

public abstract class PickableItem extends Item {

    public PickableItem(ObjectType type) {
        super(type);
    }

    public void pick() {
        // TODO add item to users inventory
    }
}
