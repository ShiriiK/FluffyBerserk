package en.fluffyBerserk.gui.animations;

import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.invariables.Invariables;
import javafx.scene.image.Image;

public class MovableEntityAnimations {
    public Sprite sprite;
    public Image[] moveDown;
    public Image[] moveLeft;
    public Image[] moveRight;
    public Image[] moveUp;
    public Image[] idle;


    public MovableEntityAnimations(Object object, LocateImage sprite){
        int w = Invariables.CELLS_SIZE;
        int h = Invariables.CELLS_SIZE;
        moveDown = new Image[3];
        moveLeft = new Image[3];
        moveRight = new Image[3];
        moveUp = new Image[3];
        idle = new Image[1];

        moveDown[0] = new Sprite(object, 0,0, w, h, sprite).getFrame();
        moveDown[1] = new Sprite(object, w,0, w, h, sprite).getFrame();
        moveDown[2] = new Sprite(object, w*2,0, w, h, sprite).getFrame();
        moveLeft[0] = new Sprite(object, 0,h, w, h, sprite).getFrame();
        moveLeft[1] = new Sprite(object, w,h, w, h, sprite).getFrame();
        moveLeft[2] = new Sprite(object, w*2,h, w, h, sprite).getFrame();
        moveRight[0] = new Sprite(object, 0,h*2, w, h, sprite).getFrame();
        moveRight[1] =  new Sprite(object, w,h*2, w, h, sprite).getFrame();
        moveRight[2] =  new Sprite(object, w*2,h*2, w, h, sprite).getFrame();
        moveUp[0] = new Sprite(object, 0,h*3, w, h, sprite).getFrame();
        moveUp[1] = new Sprite(object, w,h*3, w, h, sprite).getFrame();
        moveUp[2] = new Sprite(object, w*2,h*3, w, h, sprite).getFrame();

        idle[0] = moveDown[1];
    }

    public Image[] getMoveDown(){
        return moveDown;
    }

    public Image[] getMoveLeft(){
        return moveLeft;
    }

    public Image[] getMoveRight(){
        return moveRight;
    }

    public Image[] getMoveUp(){
        return moveUp;
    }

    public Image[] getIdle(){
        return idle;
    }
}
