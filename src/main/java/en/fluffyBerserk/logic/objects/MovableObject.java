package en.fluffyBerserk.logic.objects;

public interface MovableObject {

    public void setMoveX(float moveX);

    public void setMoveY(float moveY);

    public float getMoveX();

    public float getMoveY();

    public void move();
}
