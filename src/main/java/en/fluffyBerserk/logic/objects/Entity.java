package en.fluffyBerserk.logic.objects;

/**
 * Abstract class for all static objects
 */

public abstract class Entity implements Object {

    private float x;

    private float y;

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }
}
