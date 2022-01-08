package en.fluffyBerserk.logic.objects.bullets;

import en.fluffyBerserk.invariables.Constant;
import en.fluffyBerserk.logic.objects.Entity;
import en.fluffyBerserk.logic.objects.creatures.Creature;
import en.fluffyBerserk.logic.objects.creatures.player.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bullet extends Entity {

    private int direction;
    private Creature shooter;
    private GraphicsContext graphicsContext;
    private final Image bulletImg = new Image("bullets/flufball_basic.png");
    private float startPosX;
    private float startPosY;

    public Bullet(int direction, Creature shooter, float worldX, float worldY, GraphicsContext graphicsContext) {
        this.direction = direction;
        this.shooter = shooter;
        this.graphicsContext = graphicsContext;

        setWorldX(worldX+16);
        setWorldY(worldY+16);
        this.startPosX = getWorldX();
        this.startPosY = getWorldY();


        startMove();
    }

    private void move() {
        int speed = 10;
        if (direction == 0) setWorldY(getWorldY() - speed);
        if (direction == 1) {
            setWorldX(getWorldX() + speed);
            setWorldY(getWorldY() - speed);
        }
        if (direction == 2) setWorldX(getWorldX() + speed);
        if (direction == 3) {
            setWorldX(getWorldX() + speed);
            setWorldY(getWorldY() + speed);
        }
        if (direction == 4) setWorldY(getWorldY() + speed);
        if (direction == 5) {
            setWorldX(getWorldX() - speed);
            setWorldY(getWorldY() + speed);
        }
        if (direction == 6) setWorldX(getWorldX() - speed);
        if (direction == 7) {
            setWorldX(getWorldX() - speed);
            setWorldY(getWorldY() - speed);
        }


        float drawingX = getWorldX() - shooter.getWorldX() + Player.screenX;
        float drawingY = getWorldY() - shooter.getWorldY() + Player.screenY;

        if (drawingX > -32 || drawingY > -32
                || drawingX < Constant.SCREEN_WIDTH + 32
                || drawingY < Constant.SCREEN_HEIGHT + 32) {
            graphicsContext.drawImage(bulletImg, drawingX, drawingY, 32, 32);
        }
    }

    private void startMove(){
        AnimationTimer bulletTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                move();
            }
        };
        bulletTimer.start();
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
