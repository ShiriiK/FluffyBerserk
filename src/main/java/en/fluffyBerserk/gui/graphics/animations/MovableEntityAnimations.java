package en.fluffyBerserk.gui.graphics.animations;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.gui.graphics.sprites.SpriteImage;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Class defining structure for animations for movable entities
 */
public class MovableEntityAnimations {
    public ArrayList<Image> moveDown;
    public ArrayList<Image> moveLeft;
    public ArrayList<Image> moveRight;
    public ArrayList<Image> moveUp;
    public LocateImage usedSprite;

    /**
     * Creates animations for entity based on chosen sprite
     *
     * @param sprite image in resources folder that contains multiple images of given entity
     */
    public MovableEntityAnimations(LocateImage sprite) {
        usedSprite = new LocateImage(sprite.getPath(), sprite.getIndex());
        int w = Constants.BASE_TILE_SIZE;
        int h = Constants.BASE_TILE_SIZE;
        moveDown = new ArrayList<>(3);
        moveLeft = new ArrayList<>(3);
        moveRight = new ArrayList<>(3);
        moveUp = new ArrayList<>(3);

        moveDown.add(0, new SpriteImage(sprite, 0, 0, w, h).getFrame());
        moveDown.add(1, new SpriteImage(sprite, w, 0, w, h).getFrame());
        moveDown.add(2, new SpriteImage(sprite, w * 2, 0, w, h).getFrame());
        moveLeft.add(0, new SpriteImage(sprite, 0, h, w, h).getFrame());
        moveLeft.add(1, new SpriteImage(sprite, w, h, w, h).getFrame());
        moveLeft.add(2, new SpriteImage(sprite, w * 2, h, w, h).getFrame());
        moveRight.add(0, new SpriteImage(sprite, 0, h * 2, w, h).getFrame());
        moveRight.add(1, new SpriteImage(sprite, w, h * 2, w, h).getFrame());
        moveRight.add(2, new SpriteImage(sprite, w * 2, h * 2, w, h).getFrame());
        moveUp.add(0, new SpriteImage(sprite, 0, h * 3, w, h).getFrame());
        moveUp.add(1, new SpriteImage(sprite, w, h * 3, w, h).getFrame());
        moveUp.add(2, new SpriteImage(sprite, w * 2, h * 3, w, h).getFrame());
    }

    public ArrayList<Image> getMoveDown() {
        return moveDown;
    }

    public ArrayList<Image> getMoveLeft() {
        return moveLeft;
    }

    public ArrayList<Image> getMoveRight() {
        return moveRight;
    }

    public ArrayList<Image> getMoveUp() {
        return moveUp;
    }
}
