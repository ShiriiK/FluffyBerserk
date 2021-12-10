package en.fluffyBerserk.objects.creatures.player;

import en.fluffyBerserk.objects.creatures.CanAttack;
import en.fluffyBerserk.objects.creatures.CanShoot;
import en.fluffyBerserk.objects.creatures.Creature;

public class Player extends Creature implements CanShoot, CanAttack {

    @Override
    public String getImagePath() {
        return null;
    }

    @Override
    public String getName() {
        return ""; // TODO players name
    }

    @Override
    public void attack(Creature creature) {
        // TODO
    }

    @Override
    public void shoot() {
        // TODO
    }
}
