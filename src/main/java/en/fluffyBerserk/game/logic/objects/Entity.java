package en.fluffyBerserk.game.logic.objects;

import en.fluffyBerserk.game.Constants;

public abstract class Entity implements Object {

    private float x;
    private float previousX;

    private float y;
    private float previousY;

    @Override
    public void setX(float x) {
        previousX = this.x;
        this.x = x;
    }

    @Override
    public void setY(float y) {
        previousY = this.y;
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

    @Override
    public int getHeight() {
        return Constants.ENTITIES_SIZE;
    }

    @Override
    public int getWidth() {
        return Constants.ENTITIES_SIZE;
    }

    @Override
    public int getHitBoxHeight(){
        return Constants.ENTITIES_SIZE;
    }

    @Override
    public int getHitBoxWidth(){
        return Constants.ENTITIES_SIZE;
    }

    public float getPreviousX() {
        return previousX;
    }

    public float getPreviousY() {
        return previousY;
    }
}
