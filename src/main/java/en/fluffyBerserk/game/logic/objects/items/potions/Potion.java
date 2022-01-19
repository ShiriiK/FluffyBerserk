package en.fluffyBerserk.game.logic.objects.items.potions;

import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.items.PickableItem;
import en.fluffyBerserk.game.logic.objects.items.UsableItem;

public abstract class Potion extends PickableItem implements UsableItem {

    protected int effect;

    public Potion(ObjectType type) {
        super(ObjectType.ITEM);
        effect = setEffect();
    }

    protected abstract int setEffect();

    @Override
    public void use() {
        drink();
    }

    protected abstract void drink();
}
