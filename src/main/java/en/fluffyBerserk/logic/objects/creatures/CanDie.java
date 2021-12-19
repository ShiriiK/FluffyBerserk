package en.fluffyBerserk.logic.objects.creatures;

/**
 * Interface for creatures that can die
 */

public interface CanDie {

    void die();

    int looseHP(int dmg);
}
