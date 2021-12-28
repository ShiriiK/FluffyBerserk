package en.fluffyBerserk.logic.objects;

import en.fluffyBerserk.invariables.Direction;

/**
 * Interface for movable objects
 */


public interface MovableObject {

    void move(int steps, Direction direction);

    void setMoveX(float moveX);

    void setMoveY(float moveY);

    float getMoveX();

    float getMoveY();

    void move();
}
