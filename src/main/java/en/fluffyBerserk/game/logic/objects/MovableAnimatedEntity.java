package en.fluffyBerserk.game.logic.objects;

import en.fluffyBerserk.game.animations.AnimationManager;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

public abstract class MovableAnimatedEntity extends MovableEntity implements MovableObject {

    private final AnimationManager animationManager;

    public MovableAnimatedEntity(LocateImage sprite) {
        animationManager = new AnimationManager(sprite, this);
    }

    public void setMoveX(float moveX) {
        super.setMoveX(moveX);
        animationManager.moveXUpdated();
    }

    public void setMoveY(float moveY) {
        super.setMoveY(moveY);
        animationManager.moveYUpdated();
    }

    @Override
    public void move() {
        super.move();
        increaseTick();
    }

    protected void increaseTick(){
        animationManager.increaseTick();
    }

    @Override
    public Image getImage() {
        return animationManager.getImage();
    }
}
