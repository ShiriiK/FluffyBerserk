package en.fluffyBerserk.game.logic.objects.creatures.player;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.animations.SpritesFactory;
import en.fluffyBerserk.game.logic.Direction;
import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.MovableAnimatedEntity;
import en.fluffyBerserk.persistence.models.Character;

public final class Player extends MovableAnimatedEntity implements HasName {

    public static final float PLAYER_SPEED = 8F;

    private final Character character;

    public Player(Character character) {
        super(SpritesFactory.getSpriteByNumber(character.getSpriteIndex()), ObjectType.PLAYER);
        this.character = character;
    }



    @Override
    public String getName() {
        return character.getName();
    }

    @Override
    public int getHitBoxHeight(){
        return Constants.ENTITIES_SIZE/3;
    }

    @Override
    public int getHitBoxWidth(){
        return Constants.ENTITIES_SIZE/3;
    }

    @Override
    public float getHitBoxX(){
        return hitBoxX;
    }

    @Override
    public float getHitBoxY(){
        return hitBoxY;
    }
}
