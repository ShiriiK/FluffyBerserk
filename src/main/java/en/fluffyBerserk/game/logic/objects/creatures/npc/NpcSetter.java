package en.fluffyBerserk.game.logic.objects.creatures.npc;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.creatures.npc.npcs.ArcherCatto;
import en.fluffyBerserk.game.logic.objects.creatures.npc.npcs.ZombieCatto;

public class NpcSetter {

    public static Entity setZombieCatto(float x, float y) {
        Entity entity = new ZombieCatto();
        entity.setX(x * Constants.TILE_SIZE);
        entity.setY(y * Constants.TILE_SIZE);
        return entity;
    }

    public static Entity setArcherCatto(float x, float y) {
        Entity entity = new ArcherCatto();
        entity.setX(x * Constants.TILE_SIZE);
        entity.setY(y * Constants.TILE_SIZE);
        return entity;
    }
}
