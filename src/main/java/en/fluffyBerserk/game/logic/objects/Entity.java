package en.fluffyBerserk.game.logic.objects;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.logic.ObjectType;

public abstract class Entity implements Object {

    private float x;
    private float previousX;

    private float y;
    private float previousY;

    private float hitBoxX;
    private float hitBoxY;

    protected final ObjectType type;

    public Entity(ObjectType type) {
        this.type = type;
    }

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

    @Override
    public void setHitBoxX(float x){
        hitBoxX = x;
    }

    @Override
    public void setHitBoxY( float x){
        hitBoxY = y;
    }

    @Override
    public float getHitBoxX(){
        return getX();
    }

    @Override
    public float getHitBoxY(){
        return getY();
    }

    public float getPreviousX() {
        return previousX;
    }

    public float getPreviousY() {
        return previousY;
    }

    public ObjectType getType() {
        return type;
    }
}
