package en.fluffyBerserk.game.logic.objects.creatures.player;

import en.fluffyBerserk.game.logic.HasName;
import en.fluffyBerserk.game.logic.objects.MovableAnimatedEntity;
import en.fluffyBerserk.game.animations.SpritesFactory;
import en.fluffyBerserk.persistence.models.Character;

public final class Player extends MovableAnimatedEntity implements HasName {

    public static final float PLAYER_SPEED = 6F;

    private final Character character;

    public Player(Character character) {
        super(SpritesFactory.getSpriteByNumber(character.getSpriteIndex()));
        this.character = character;
    }

    @Override
    public String getName() {
        return character.getName();
    }

    public Character getCharacter() {
        return character;
    }
}
