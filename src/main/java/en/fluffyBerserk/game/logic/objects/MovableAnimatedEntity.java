package en.fluffyBerserk.game.logic.objects;

import en.fluffyBerserk.game.logic.Direction;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.gui.graphics.animations.AnimationManager;
import en.fluffyBerserk.gui.graphics.animations.MovableEntityAnimationManager;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

public abstract class MovableAnimatedEntity extends MovableEntity {

    private MovableEntityAnimationManager movableEntityAnimationManager;
    private AnimationManager animationManager;

    public MovableAnimatedEntity(LocateImage sprite, ObjectType type) {
        super(type);
        movableEntityAnimationManager = new MovableEntityAnimationManager(sprite, this);
    }

    public void setMoveX(float moveX) {
        super.setMoveX(moveX);
        movableEntityAnimationManager.moveXUpdated();
    }

    public void setMoveY(float moveY) {
        super.setMoveY(moveY);
        movableEntityAnimationManager.moveYUpdated();
    }

    @Override
    public void move() {
        super.move();
        movableEntityAnimationManager.increaseTick();
    }

    @Override
    public Image getImage() {
        return movableEntityAnimationManager.getImage();
    }

    public Direction getDirection() {
        return movableEntityAnimationManager.direction;
    }
}
