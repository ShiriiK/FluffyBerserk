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

    public ZombieCatto() {
        this.isAlive = true;
        init();
    }

    public void init() {
        Random rand = new Random();
        int upperbound = 500;
        setY(rand.nextInt(upperbound));
        setX(rand.nextInt(upperbound));
        setHp(20);
        setStr(5);
        direction = "down";
        counter = 0;
        imgNumber = 1;
        npcAnimations = new MovableEntityAnimations(SpritesFactory.getImages()[13]);
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

    public void renderNpc(GraphicsContext graphicsContext) {
        MovableEntityAnimations npcAnimations = ZombieCatto.getPlayerAnimations();
        Image image = npcAnimations.getMoveDown().get(1);
        graphicsContext.drawImage(image, x, y, Invariables.TILE_SIZE, Invariables.TILE_SIZE);

    }

    public void npcMovement(float player_x, float player_y) {
        if (player_x > x) {

            this.setX(x + npc_speed);
        }
        if (player_x < x) {
            this.setX(x - npc_speed);
        }
        if (player_y > y) {
            this.setY(y + npc_speed);
        }
        if (player_y < y) {
            this.setY(y - npc_speed);
        }
    }
}
