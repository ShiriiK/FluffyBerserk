package en.fluffyBerserk.game.logic;

import en.fluffyBerserk.game.logic.objects.Object;

public class Collision {

    public static boolean objectsCollide(Object obj1, Object obj2) {
        return obj1.getX() < obj2.getX() + obj2.getHitBoxWidth() &&
                obj1.getX() + obj1.getHitBoxWidth() > obj2.getX() &&
                obj1.getY() < obj2.getY() + obj2.getHitBoxHeight() &&
                obj1.getHitBoxHeight() + obj1.getY() > obj2.getY();
    }
}
