package en.fluffyBerserk.logic.objects;

/**
 * Abstract class for all movable objects
 */

public abstract class MovableEntity extends Entity implements MovableObject {


    protected String direction;
    protected int speed;
    public int counter;
    public int imgNumber;

    private float moveX;

    private float moveY;

    @Override
    public void setMoveX(float moveX) {
        this.moveX = moveX;
    }

    @Override
    public void setMoveY(float moveY) {
        this.moveY = moveY;
    }

    @Override
    public float getMoveX() {
        return moveX;
    }

    @Override
    public float getMoveY() {
        return moveY;
    }

    @Override
    public void move() {
        setX(getX() + moveX);
        setY(getY() + moveY);
    }
}
