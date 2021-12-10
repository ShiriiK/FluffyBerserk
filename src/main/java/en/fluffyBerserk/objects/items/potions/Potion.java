package en.fluffyBerserk.objects.items.potions;

import en.fluffyBerserk.objects.items.PickableItem;
import en.fluffyBerserk.objects.items.UsableItem;

public abstract class Potion extends PickableItem implements UsableItem {

    @Override
    public void use() {
        drink();
    }

    protected abstract void drink();
}
