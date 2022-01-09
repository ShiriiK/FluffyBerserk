package en.fluffyBerserk.logic.objects.bullets;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import en.fluffyBerserk.invariables.Constant;
import en.fluffyBerserk.logic.objects.Entity;
import en.fluffyBerserk.logic.objects.creatures.Creature;
import en.fluffyBerserk.logic.objects.creatures.player.Player;
import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Bullet extends Entity {

    private int direction;
    private Creature shooter;
    private GraphicsContext graphicsContext;
    private Image bulletImg = new Image("bullets/flufball_basic.png");
    private float startPosX;
    private float startPosY;
    public Rectangle hitBox;

    public Bullet(int direction, Creature shooter, float worldX, float worldY, GraphicsContext graphicsContext) {
        this.direction = direction;
        this.shooter = shooter;
        this.graphicsContext = graphicsContext;

        setWorldX(worldX+16);
        setWorldY(worldY+16);
        this.startPosX = getWorldX();
        this.startPosY = getWorldY();

        setHitBox();

        startMove();
    }

    private void move() {
        int speed = 10;
        switch(direction) {
            case 0:
                setWorldY(getWorldY() - speed);
                break;
            case 1:
                setWorldX(getWorldX() + speed);
                setWorldY(getWorldY() - speed);
                break;
            case 2:
                setWorldX(getWorldX() + speed);
                break;
            case 3:
                setWorldX(getWorldX() + speed);
                setWorldY(getWorldY() + speed);
                break;
            case 4:
                setWorldY(getWorldY() + speed);
                break;
            case 5:
                setWorldX(getWorldX() - speed);
                setWorldY(getWorldY() + speed);
                break;
            case 6:
                setWorldX(getWorldX() - speed);
                break;
            case 7:
                setWorldX(getWorldX() - speed);
                setWorldY(getWorldY() - speed);
                break;
        }
        setHitBox();
        drawBullet();
    }

    private void drawBullet() {
        float drawingX = getWorldX() - shooter.getWorldX() + Player.screenX;
        float drawingY = getWorldY() - shooter.getWorldY() + Player.screenY;

        if (drawingX > -32 || drawingY > -32
                || drawingX < Constant.SCREEN_WIDTH + 32
                || drawingY < Constant.SCREEN_HEIGHT + 32) {
            graphicsContext.drawImage(bulletImg, drawingX, drawingY, Constant.TILE_SIZE/2, Constant.TILE_SIZE/2);
        }
    }

    private void startMove(){
        AnimationTimer bulletTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                move();
                //checkCollision();
            }
        };
        bulletTimer.start();
    }

    private void checkCollision(Bounds bounds) {            // TODO
        if (hitBox.intersects(bounds)) {
            bulletImg = new Image("bullets/flufball_blue.png");
        }
    }

    private void setHitBox() {
        hitBox = new Rectangle(getWorldX(), getWorldY(), Constant.TILE_SIZE/2, Constant.TILE_SIZE/2);
    }

    @Override
    public String getImagePath() {
        return ""; // TODO
    }

    @Override
    public String getName() {
        //return shooter.getName() + "Bullet";
        return "bullet";
    }
}
