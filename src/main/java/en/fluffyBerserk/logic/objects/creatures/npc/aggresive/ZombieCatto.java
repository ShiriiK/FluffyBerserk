package en.fluffyBerserk.logic.objects.creatures.npc.aggresive;

import en.fluffyBerserk.gui.animations.MovableEntityAnimations;
import en.fluffyBerserk.gui.animations.SpritesFactory;
import en.fluffyBerserk.invariables.Invariables;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public class ZombieCatto extends AggressiveNpc {
    private boolean isAlive;
    private static MovableEntityAnimations npcAnimations;
    private Image image;


    public ZombieCatto() {
        this.isAlive = true;
        init();
    }

    public void init() {
        Random rand = new Random();
        int world_upperbound = 500;
        setY(rand.nextInt(world_upperbound));
        setX(rand.nextInt(world_upperbound));
        setHp(20);
        setStr(5);
        direction = "down";
        counter = 0;
        imgNumber = 1;
        npcAnimations = new MovableEntityAnimations(SpritesFactory.getImages()[13]);
        image = npcAnimations.getMoveDown().get(1);
    }

    public static MovableEntityAnimations getPlayerAnimations() {
        return npcAnimations;
    }

    @Override
    public String getName() {
        return "ZombieCatto";
    }

    @Override
    public String getImagePath() {
        return null;
    }

    @Override
    public void move(int steps) {

    }

    public void renderNpc(GraphicsContext graphicsContext, float player_x, float player_y) {
        graphicsContext.drawImage(image, x, y, Invariables.TILE_SIZE, Invariables.TILE_SIZE);
        npcMovement(player_x, player_y);
    }

    public void npcMovement(float player_x, float player_y) {
        boolean right = false;
        boolean left = false;
        counter++;
        if (counter > 10) {
            if (imgNumber == 1) {
                imgNumber = 2;
            } else if (imgNumber == 2) {
                imgNumber = 3;
            } else if (imgNumber == 3) {
                imgNumber = 1;
            }
            counter = 0;
        }

        if (player_x > x) {
            right = true;
            image = npcAnimations.getMoveRight().get(imgNumber-1);
            this.setX(x + npc_speed);
        }
        if (player_x < x) {
            left = true;
            image = npcAnimations.getMoveLeft().get(imgNumber-1);
            this.setX(x - npc_speed);
        }
        if (player_y > y) {
            if (right && !left) {
                image = npcAnimations.getMoveDown().get(imgNumber-1);
            }
            this.setY(y + npc_speed);
        }
        if (player_y < y) {
            if (!right && left) {
                image = npcAnimations.getMoveUp().get(imgNumber-1);

            }
            this.setY(y - npc_speed);

        }
    }
}
