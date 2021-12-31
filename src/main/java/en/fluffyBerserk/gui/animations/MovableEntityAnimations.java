package en.fluffyBerserk.gui.animations;

import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.invariables.Invariables;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class MovableEntityAnimations {
    public ArrayList<Image> moveDown;
    public ArrayList<Image> moveLeft;
    public ArrayList<Image> moveRight;
    public ArrayList<Image> moveUp;
    public ArrayList<Image> idle;


    public MovableEntityAnimations(Object object, LocateImage sprite) {
        int w = Invariables.DEF_TILE_SIZE;
        int h = Invariables.DEF_TILE_SIZE;
        moveDown = new ArrayList<>(3);
        moveLeft = new ArrayList<>(3);
        moveRight = new ArrayList<>(3);
        moveUp = new ArrayList<>(3);
        idle = new ArrayList<>(1);

        moveDown.add(0, new Sprite(object, 0, 0, w, h, sprite).getFrame());
        moveDown.add(1, new Sprite(object, w, 0, w, h, sprite).getFrame());
        moveDown.add(2, new Sprite(object, w * 2, 0, w, h, sprite).getFrame());
        moveLeft.add(0, new Sprite(object, 0, h, w, h, sprite).getFrame());
        moveLeft.add(1, new Sprite(object, w, h, w, h, sprite).getFrame());
        moveLeft.add(2, new Sprite(object, w * 2, h, w, h, sprite).getFrame());
        moveRight.add(0, new Sprite(object, 0, h * 2, w, h, sprite).getFrame());
        moveRight.add(1, new Sprite(object, w, h * 2, w, h, sprite).getFrame());
        moveRight.add(2, new Sprite(object, w * 2, h * 2, w, h, sprite).getFrame());
        moveUp.add(0, new Sprite(object, 0, h * 3, w, h, sprite).getFrame());
        moveUp.add(1, new Sprite(object, w, h * 3, w, h, sprite).getFrame());
        moveUp.add(2, new Sprite(object, w * 2, h * 3, w, h, sprite).getFrame());

        idle.add(0, moveDown.get(1));
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

    public ArrayList<Image> getIdle() {
        return idle;
    }
}
