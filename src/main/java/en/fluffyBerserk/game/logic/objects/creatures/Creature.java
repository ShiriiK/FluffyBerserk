package en.fluffyBerserk.game.logic.objects.creatures;

import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.MovableAnimatedEntity;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

public abstract class Creature extends MovableAnimatedEntity implements HasName {

    protected int hp;
    protected int maxHp;
    protected float npcSpeed;
    protected int dmg;

    public Creature(LocateImage sprite, ObjectType type) {
        super(sprite, type);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int hp) {
        this.hp = hp;
        this.maxHp = hp;
    }

    public float getNpcSpeed() {
        return npcSpeed;
    }

    public void setNpcSpeed(float npcSpeed) {
        this.npcSpeed = npcSpeed;
    }

    public int getDmg() {
        return this.dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void damaged(int incomingDmg) {this.hp -= incomingDmg;}
}
