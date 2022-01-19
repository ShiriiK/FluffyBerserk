package en.fluffyBerserk.game.logic.objects.creatures.player;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.MovableAnimatedEntity;
import en.fluffyBerserk.game.logic.objects.creatures.CanAttack;
import en.fluffyBerserk.gui.graphics.sprites.SpritesFactory;
import en.fluffyBerserk.persistence.models.Character;

public final class Player extends MovableAnimatedEntity implements HasName, CanAttack {

    public static final float PLAYER_SPEED = 8F;

    private final Character character;

    private int maxCd = 50;
    private int attackCd = 0; //
    private int hp = 0;

    public Player(Character character) {
        super(SpritesFactory.getSpriteByNumber(character.getSpriteIndex()), ObjectType.PLAYER);
        this.character = character;
        this.hp = character.getStamina() * Constants.PLAYER_HP_SCALE;
    }

    @Override
    public String getName() {
        return character.getName();
    }

    @Override
    public int getHitBoxHeight() {
        return Constants.ENTITIES_SIZE / 3;
    }

    @Override
    public int getHitBoxWidth() {
        return Constants.ENTITIES_SIZE / 3;
    }

    @Override
    public float getHitBoxX() {
        return hitBoxX;
    }

    @Override
    public float getHitBoxY() {
        return hitBoxY;
    }

    @Override
    public boolean canAttack() {
        return attackCd == maxCd;
    }

    public int getMaxCd() {
        return maxCd;
    }

    public void setMaxCd(int cd){
        maxCd = cd;
    }

    @Override
    public void reduceCooldown() {
        if (attackCd != maxCd) ++attackCd;
    }

    @Override
    public void resetCooldown() {
        attackCd = 0;
    }

    public int getDmg() {return character.getStrength() * Constants.PLAYER_DMG_SCALE;}   // Should return total damage of  player with initial number
                                                            // plus equipment bonuses in future

    public int getHp() {
        return hp;                 // Hp of player = stamina * 10
    }

    public void damaged(int dmg) {
        this.hp -= dmg;
    }

    public boolean isDead(){
        return hp <= 0;
    }

    public void regenHp() {this.hp = character.getStamina() * Constants.PLAYER_HP_SCALE;}

    public Character getCharacter() {
        return character;
    }

    public void refreshSprite(){
        updateSpriteForMAE(SpritesFactory.getSpriteByNumber(character.getSpriteIndex()));
    }
}
