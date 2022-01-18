package en.fluffyBerserk.game.logic.objects.creatures;

import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.objects.MovableAnimatedEntity;
import en.fluffyBerserk.gui.utils.LocateImage;

public abstract class Creature extends MovableAnimatedEntity implements HasName {

    private int hp;
    private int str;
    private int level;
    private float npcSpeed;
    private int dmg;

    public Creature(LocateImage sprite) { super(sprite); }

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

    public float getNpcSpeed(){return npcSpeed;}

    public void setNpcSpeed(float npcSpeed){this.npcSpeed = npcSpeed;}

    public void setDmg(int dmg){this.dmg = dmg;}
    public int getDmg(){return this.dmg;}
}
