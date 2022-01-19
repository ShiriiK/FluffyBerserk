package en.fluffyBerserk.game.logic.objects.creatures;

import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.MovableAnimatedEntity;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

public abstract class Creature extends MovableAnimatedEntity implements HasName {

    private int hp;
    private int str;
    private int armor;
    private int stamina;
    private int intelllect;
    private int level;
    private float npcSpeed;
    private int dmg;

    public Creature(LocateImage sprite, ObjectType type) {
        super(sprite, type);
    }


    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getIntelllect() {
        return intelllect;
    }

    public void setIntelllect(int intelllect) {
        this.intelllect = intelllect;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
