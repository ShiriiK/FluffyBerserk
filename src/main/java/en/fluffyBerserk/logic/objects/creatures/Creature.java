package en.fluffyBerserk.logic.objects.creatures;

import en.fluffyBerserk.logic.objects.HasName;
import en.fluffyBerserk.logic.objects.MovableEntity;

/**
 * Abstract class for all creatures
 */
public abstract class Creature extends MovableEntity implements HasName {

    private int hp;
    private int str;
    private int level;

    public void setStr(int str) {
        this.str = str;
    }

    public int getStr() {
        return str;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
