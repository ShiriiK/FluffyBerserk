package en.fluffyBerserk.game.logic.objects.creatures;

/**
 * Interface for creatures that can attack
 */

public interface CanAttack {

    boolean canAttack();

    void reduceCooldown();

    void resetCooldown();
}
