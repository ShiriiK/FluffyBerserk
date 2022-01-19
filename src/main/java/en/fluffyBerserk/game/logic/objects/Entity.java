package en.fluffyBerserk.game.logic.objects;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.ObjectType;

public abstract class Entity implements Object {

    protected final ObjectType type;
    protected float hitBoxX;
    protected float previousHitBoxX;
    protected float hitBoxY;
    protected float previousHitBoxY;
    private float x;
    private float previousX;
    private float y;
    private float previousY;

    public Entity(ObjectType type) {
        this.type = type;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        previousX = this.x;
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        previousY = this.y;
        this.y = y;
    }

    @Override
    public int getHeight() {
        return Constants.TILE_SIZE;
    }

    @Override
    public int getWidth() {
        return Constants.TILE_SIZE;
    }

    @Override
    public int getHitBoxHeight() {
        return getHeight();
    }

    @Override
    public int getHitBoxWidth() {
        return getWidth();
    }

    @Override
    public float getHitBoxX() {
        return getX();
    }

    @Override
    public void setHitBoxX(float x) {
        previousHitBoxX = this.hitBoxX;
        hitBoxX = x;
    }

    @Override
    public float getHitBoxY() {
        return getY();
    }

    @Override
    public void setHitBoxY(float y) {
        previousHitBoxY = this.hitBoxY;
        hitBoxY = y;
    }

    public float getPreviousX() {
        return previousX;
    }

    public float getPreviousY() {
        return previousY;
    }

    public float getPreviousHitBoxX() {
        return previousHitBoxX;
    }

    public float getPreviousHitBoxY() {
        return previousHitBoxY;
    }


    public ObjectType getType() {
        return type;
    }
}
