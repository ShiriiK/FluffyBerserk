package en.fluffyBerserk.logic.objects.items.potions;

import en.fluffyBerserk.logic.objects.items.PickableItem;
import en.fluffyBerserk.logic.objects.items.UsableItem;

public abstract class Potion extends PickableItem implements UsableItem {

    @Override
    public void use() {
        drink();
    }

    protected abstract void drink();
}
