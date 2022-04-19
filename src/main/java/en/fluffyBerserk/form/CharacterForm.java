package en.fluffyBerserk.form;

import en.fluffyBerserk.gui.graphics.sprites.SpritesFactory;
import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.persistence.models.Character;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CharacterForm extends Form {

    private int pointsLeft = 5;

    @Nullable
    private String name = null;

    private int stamina = 5;

    private int strength = 5;

    private int intellect = 0;

    private int armor = 0;

    @NotNull
    private LocateImage sprite;

    public CharacterForm(@Nullable Character character) {
        if (character == null) {
            sprite = SpritesFactory.getRandomSprite();
            return;
        }

        pointsLeft = 0;
        name = character.getName();
        stamina = character.getStamina();
        strength = character.getStrength();
        intellect = character.getIntellect();
        armor = character.getArmor();

        final LocateImage sprite = SpritesFactory.getSpriteByNumber(character.getSpriteIndex());
        assert sprite != null;

        this.sprite = sprite;
    }

    public @Nullable String getName() {
        return name;
    }

    public void setName(@Nullable final String name) {
        this.name = name;
    }

    public int getPointsLeft() {
        return pointsLeft;
    }

    public void decrementPointsLeft() {
        pointsLeft--;
    }

    public void incrementPointsLeft() {
        pointsLeft++;
    }

    public int getStamina() {
        return stamina;
    }

    public void incrementStamina() {
        stamina++;
    }

    public void decrementStamina() {
        stamina--;
    }

    public int getStrength() {
        return strength;
    }

    public void incrementStrength() {
        strength++;
    }

    public void decrementStrength() {
        strength--;
    }

    public int getIntellect() {
        return intellect;
    }

    public void incrementIntellect() {
        intellect++;
    }

    public void decrementIntellect() {
        intellect--;
    }

    public int getArmor() {
        return armor;
    }

    public void incrementArmor() {
        armor++;
    }

    public void decrementArmor() {
        armor--;
    }

    public @NotNull LocateImage getSprite() {
        return sprite;
    }

    public void setSprite(@NotNull LocateImage sprite) {
        this.sprite = sprite;
    }

    public boolean validate() {
        if (name == null || name.isEmpty()) {
            addError("name", "Name must not be empty!");
            return false;
        }

        if (pointsLeft > 0) {
            addError("points", "You must spend all points!");
            return false;
        }

        return true;
    }
}
