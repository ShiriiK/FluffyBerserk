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

    private int attackCd = 50; //

    public Player(Character character) {
        super(SpritesFactory.getSpriteByNumber(character.getSpriteIndex()), ObjectType.PLAYER);
        this.character = character;
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
        return attackCd == Constants.PLAYER_CD;
    }

    @Override
    public void reduceCooldown() {
        if (attackCd != Constants.PLAYER_CD) ++attackCd;
    }

    @Override
    public void resetCooldown() {
        attackCd = 0;
    }

    public Character getCharacter() {
        return character;
    }

    public void refreshSprite(){
        updateSpriteForMAE(SpritesFactory.getSpriteByNumber(character.getSpriteIndex()));
    }
}
