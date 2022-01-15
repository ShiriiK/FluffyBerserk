package en.fluffyBerserk.game.logic;

import en.fluffyBerserk.game.logic.objects.Object;

public class Collision {

    public static boolean objectsCollide(Object obj1, Object obj2) {
        return obj1.getHitBoxX() < obj2.getHitBoxX() + obj2.getHitBoxWidth() &&
                obj1.getHitBoxX() + obj1.getHitBoxWidth() > obj2.getHitBoxX() &&
                obj1.getHitBoxY() < obj2.getHitBoxY() + obj2.getHitBoxHeight() &&
                obj1.getHitBoxHeight() + obj1.getHitBoxY() > obj2.getHitBoxY();
    }
}
