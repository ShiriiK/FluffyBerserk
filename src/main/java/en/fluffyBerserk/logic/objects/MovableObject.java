package en.fluffyBerserk.logic.objects;

/**
 * Interface for movable objects
 */


public interface MovableObject {

    void move(int steps);

    void setMoveX(float moveX);

    void setMoveY(float moveY);

    float getMoveX();

    float getMoveY();

    void move();
}
