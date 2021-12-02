package en.fluffyBerserk.objects.items.potions;

public class StrengthPotion extends Potion {

    private int strength;

    public StrengthPotion(int strength) {
        this.strength = strength;
    }

    @Override
    protected void drink() {
        // TODO add strength to user!
    }

    @Override
    public String getName() {
        return "Strength potion";
    }

    @Override
    public String getImagePath() {
        return ""; // TODO
    }
}
