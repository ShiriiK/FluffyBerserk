package en.fluffyBerserk.game.logic.objects;

import en.fluffyBerserk.game.animations.AnimationManager;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

public abstract class MovableEntity extends Entity implements MovableObject {

    private float moveX = 0F;

    private float moveY = 0F;

    private final AnimationManager animationManager;

    public MovableEntity(LocateImage sprite) {
        animationManager = new AnimationManager(sprite, this);
    }

    public float getMoveX() {
        return moveX;
    }

    public void setMoveX(float moveX) {
        this.moveX = moveX;
        animationManager.moveXUpdated();
    }

    public float getMoveY() {
        return moveY;
    }

    public void setMoveY(float moveY) {
        this.moveY = moveY;
        animationManager.moveYUpdated();
    }

    public boolean isMoving() {
        return moveY != 0F || moveX != 0F;
    }

    @Override
    public void move() {
        setX(getX() + moveX);
        setY(getY() + moveY);
        animationManager.increaseTick();
    }

    @Override
    public Image getImage() {
        return animationManager.getImage();
    }
}
