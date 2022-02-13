package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.creatures.npc.*;
import en.fluffyBerserk.game.logic.objects.creatures.npc.npcs.Boss1;
import en.fluffyBerserk.game.logic.objects.creatures.npc.npcs.Boss2;
import en.fluffyBerserk.game.logic.objects.creatures.npc.npcs.Boss3;
import en.fluffyBerserk.game.logic.objects.creatures.npc.npcs.Boss4;

import java.util.ArrayList;

public class EntitiesForMaps {
    private static ArrayList<Entity> entities;

    public static ArrayList<Entity> loadMap1() {
        entities = new ArrayList<>(20);

        return entities;
    }

    public static ArrayList<Entity> loadMap2() {
        entities = new ArrayList<>(20);

        return entities;
    }

    public static ArrayList<Entity> loadMap3() {
        entities = new ArrayList<>(20);

        Entity catto1 = NpcSetter.setZombieCatto(7, 16);
        Entity catto2 = NpcSetter.setZombieCatto(17, 16);
        Entity catto3 = NpcSetter.setZombieCatto(13, 10);
        Entity catto4 = NpcSetter.setZombieCatto(5, 9);
        Entity catto5 = NpcSetter.setZombieCatto(10, 2);

        Entity catto6 = NpcSetter.setArcherCatto(15, 2);
        Entity catto7 = NpcSetter.setArcherCatto(18, 4);
        Entity catto8 = NpcSetter.setArcherCatto(5, 9);

        Entity boss = new Boss1();
        boss.setX(2 * Constants.TILE_SIZE);
        boss.setY(9 * Constants.TILE_SIZE);

        entities.add(catto1);
        entities.add(catto2);
        entities.add(catto3);
        entities.add(catto4);
        entities.add(catto5);
        entities.add(catto6);
        entities.add(catto7);
        entities.add(catto8);
        entities.add(boss);

        return entities;
    }

    public static ArrayList<Entity> loadMap4() {
        entities = new ArrayList<>(20);

        Entity catto1 = NpcSetter.setZombieCatto(9, 8);
        Entity catto2 = NpcSetter.setZombieCatto(11, 16);
        Entity catto3 = NpcSetter.setZombieCatto(11, 2);
        Entity catto4 = NpcSetter.setZombieCatto(16, 7);
        Entity catto5 = NpcSetter.setZombieCatto(2, 13);

        Entity catto6 = NpcSetter.setArcherCatto(12, 9);
        Entity catto7 = NpcSetter.setArcherCatto(15, 6);
        Entity catto8 = NpcSetter.setArcherCatto(2, 3);

        Entity boss = new Boss2();
        boss.setX(14 * Constants.TILE_SIZE);
        boss.setY(15 * Constants.TILE_SIZE);

        entities.add(catto1);
        entities.add(catto2);
        entities.add(catto3);
        entities.add(catto4);
        entities.add(catto5);
        entities.add(catto6);
        entities.add(catto7);
        entities.add(catto8);
        entities.add(boss);

        return entities;
    }

    public static ArrayList<Entity> loadMap5() {
        entities = new ArrayList<>(20);

        Entity catto1 = NpcSetter.setZombieCatto(8, 9);
        Entity catto2 = NpcSetter.setZombieCatto(8, 6);
        Entity catto3 = NpcSetter.setZombieCatto(15, 4);
        Entity catto4 = NpcSetter.setZombieCatto(2, 5);
        Entity catto5 = NpcSetter.setZombieCatto(2, 13);
        Entity catto6 = NpcSetter.setZombieCatto(15, 14);
        Entity catto7 = NpcSetter.setZombieCatto(16, 14);
        Entity catto8 = NpcSetter.setZombieCatto(11, 4);

        Entity boss = new Boss3();
        boss.setX(3 * Constants.TILE_SIZE);
        boss.setY(11 * Constants.TILE_SIZE);

        entities.add(catto1);
        entities.add(catto2);
        entities.add(catto3);
        entities.add(catto4);
        entities.add(catto5);
        entities.add(catto6);
        entities.add(catto7);
        entities.add(catto8);
        entities.add(boss);

        return entities;
    }

    public static ArrayList<Entity> loadMap6() {
        entities = new ArrayList<>(20);

        Entity catto1 = NpcSetter.setZombieCatto(8, 4);
        Entity catto2 = NpcSetter.setZombieCatto(12, 4);
        Entity catto3 = NpcSetter.setZombieCatto(3, 13);
        Entity catto4 = NpcSetter.setZombieCatto(12, 3);
        Entity catto5 = NpcSetter.setZombieCatto(3, 18);

        Entity catto6 = NpcSetter.setArcherCatto(5, 8);
        Entity catto7 = NpcSetter.setArcherCatto(11, 3);
        Entity catto8 = NpcSetter.setArcherCatto(14, 13);

        Entity boss = new Boss4();
        boss.setX(5 * Constants.TILE_SIZE);
        boss.setY(3 * Constants.TILE_SIZE);

        entities.add(catto1);
        entities.add(catto2);
        entities.add(catto3);
        entities.add(catto4);
        entities.add(catto5);
        entities.add(catto6);
        entities.add(catto7);
        entities.add(catto8);
        entities.add(boss);

        return entities;
    }
}
