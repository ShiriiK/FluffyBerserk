package en.fluffyBerserk.game.logic.objects;

public abstract class MovableEntity extends Entity implements MovableObject {

    private float moveX = 0F;

    private float moveY = 0F;

    public float getMoveX() {
        return moveX;
    }

    public void setMoveX(float moveX) {
        this.moveX = moveX;
    }

    public float getMoveY() {
        return moveY;
    }

    public void setMoveY(float moveY) {
        this.moveY = moveY;
    }

    public boolean isMoving() {
        return moveY != 0F || moveX != 0F;
    }

    @Override
    public void move() {
        setX(getX() + moveX);
        setY(getY() + moveY);
    }
}
