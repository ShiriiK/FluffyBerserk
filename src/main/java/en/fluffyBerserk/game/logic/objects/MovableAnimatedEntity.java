package en.fluffyBerserk.game.logic.objects;

import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.gui.graphics.animations.MovableEntityAnimationManager;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

public abstract class MovableAnimatedEntity extends MovableEntity {

    private final MovableEntityAnimationManager animationManager;

    public MovableAnimatedEntity(LocateImage sprite, ObjectType type) {
        super(type);
        animationManager = new MovableEntityAnimationManager(sprite, this);
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
        animationManager.increaseTick();
    }

    @Override
    public Image getImage() {
        return animationManager.getImage();
    }
}
