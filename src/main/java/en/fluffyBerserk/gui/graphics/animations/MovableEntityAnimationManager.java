package en.fluffyBerserk.gui.graphics.animations;

import en.fluffyBerserk.game.logic.Direction;
import en.fluffyBerserk.game.logic.objects.MovableEntity;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class MovableEntityAnimationManager {

    private static final int CHANGE_ANIMATION_NUMBER = 10;
    private final MovableEntityAnimations animations;
    private final MovableEntity entity;
    public Direction direction = Direction.DOWN;
    public int animationNumber = 0;
    private int ticks = 0;

    public MovableEntityAnimationManager(LocateImage sprite, MovableEntity entity) {
        this.entity = entity;
        animations = new MovableEntityAnimations(sprite);
    }

    private ArrayList<Image> getAnimationList() {
        switch (direction) {
            case UP:
                return animations.getMoveUp();
            case RIGHT:
                return animations.getMoveRight();
            case DOWN:
                return animations.getMoveDown();
            case LEFT:
                return animations.getMoveLeft();
            default:
                throw new IllegalArgumentException("Invalid direction!");
        }
    }

    public void moveXUpdated() {
        if (entity.getMoveX() > 0F || entity.getMoveX() < 0F) {
            checkXDirection();
        } else {
            checkYDirection();
        }
    }

    public void moveYUpdated() {
        if (entity.getMoveY() > 0F || entity.getMoveY() < 0F) {
            checkYDirection();
        } else {
            checkXDirection();
        }
    }

    private void checkYDirection() {
            if (entity.getMoveY() > 0F) {
                direction = Direction.DOWN;
            } else if (entity.getMoveY() < 0F) {
                direction = Direction.UP;
            }
    }

    private void checkXDirection() {
        if (entity.getMoveX() > 0F) {
            direction = Direction.RIGHT;
        } else if (entity.getMoveX() < 0F) {
            direction = Direction.LEFT;
        }
    }

    public Image getImage() {
        // Entity is not moving, always return index 1 => standing
        if (!entity.isMoving()) {
         return getAnimationList().get(1);
         }
        return getAnimationList().get(animationNumber);
    }

    public void increaseTick() {
        if (!entity.isMoving()) {
            return;
        }

        ticks++;

        if (ticks % CHANGE_ANIMATION_NUMBER == 0) {
            ticks = 0;
            animationNumber = (animationNumber + 1) > 2 ? 0 : animationNumber + 1;
        }

    }
}
