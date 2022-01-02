package en.fluffyBerserk.form;

import org.jetbrains.annotations.Nullable;

public final class SlotForm extends Form {

    private int pointsLeft = 20;

    @Nullable
    private String name = null;

    private int stamina = 0;

    private int strength = 0;

    private int intellect = 0;

    private int armor = 0;

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
