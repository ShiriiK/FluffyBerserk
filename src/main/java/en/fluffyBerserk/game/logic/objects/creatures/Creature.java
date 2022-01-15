package en.fluffyBerserk.game.logic.objects.creatures;

import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.MovableEntity;

public abstract class Creature extends MovableEntity implements HasName {

    private int hp;
    private int str;
    private int level;

    public Creature(ObjectType type) {
        super(type);
    }

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
