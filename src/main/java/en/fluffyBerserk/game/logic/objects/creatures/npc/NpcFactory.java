package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.creatures.Creature;

import java.util.Random;

public class NpcFactory {

    public static void init(Creature creature) {
        creature.setY(getSpawnableY());
        creature.setX(getSpawnableX());
        creature.setHp(20);
        creature.setStr(5);
        creature.setNpcSpeed(2F);
        creature.setMoveX(creature.getNpcSpeed());
        creature.setMoveY(creature.getNpcSpeed());
    }


    public static int getSpawnableX() {
        Random random = new Random();
        return random.nextInt((Constants.WORLD_HEIGHT - Constants.TILE_SIZE - Constants.TILE_SIZE) + Constants.TILE_SIZE);
    }

    public static int getSpawnableY() {
        Random random = new Random();
        return random.nextInt((Constants.WORLD_WIDTH - Constants.TILE_SIZE - Constants.TILE_SIZE) + Constants.TILE_SIZE);
    }

}
