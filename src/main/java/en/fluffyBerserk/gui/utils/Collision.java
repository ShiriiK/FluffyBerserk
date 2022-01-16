package en.fluffyBerserk.gui.utils;

import en.fluffyBerserk.game.logic.objects.Object;

public class Collision {

    public static boolean objectsCollide(Object obj1, Object obj2) {
        return obj1.getHitBoxX() < obj2.getHitBoxX() + obj2.getHitBoxWidth() &&
                obj1.getHitBoxX() + obj1.getHitBoxWidth() > obj2.getHitBoxX() &&
                obj1.getHitBoxY() < obj2.getHitBoxY() + obj2.getHitBoxHeight() &&
                obj1.getHitBoxHeight() + obj1.getHitBoxY() > obj2.getHitBoxY();
    }

    public static boolean objectsCollide2(Object obj1, Object obj2) {
        return obj1.getX() < obj2.getX() + obj2.getWidth() &&
                obj1.getX() + obj1.getWidth() > obj2.getX() &&
                obj1.getY() < obj2.getY() + obj2.getHeight() &&
                obj1.getHeight() + obj1.getY() > obj2.getY();
    }

}
