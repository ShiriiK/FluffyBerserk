package en.fluffyBerserk.game.logic.objects.items.potions;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.items.Pickable;
import en.fluffyBerserk.game.logic.objects.items.Useable;

import java.util.HashMap;

public abstract class Potion extends Entity implements Useable, Pickable, HasName {

    protected int effect;

    public Potion(ObjectType type) {
        super(type);
        effect = setEffect();
    }

    @Override
    public int getHeight(){
        return Constants.TILE_SIZE/2;
    }

    @Override
    public int getWidth(){
        return Constants.TILE_SIZE/2;
    }

    protected abstract int setEffect();

    @Override
    public void use() {
        drink();
    }

    protected abstract void drink();
}
