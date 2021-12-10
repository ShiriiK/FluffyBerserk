package en.fluffyBerserk.objects.creatures;

import en.fluffyBerserk.objects.HasName;
import en.fluffyBerserk.objects.MovableEntity;

public abstract class Creature extends MovableEntity implements HasName {

    private int health;

    private int level;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
