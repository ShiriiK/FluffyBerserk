package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.creatures.npc.*;

import java.util.ArrayList;

public class EntitiesForMaps {
    private static ArrayList<Entity> entities;

    private static Entity setZombieCatto(float x, float y) {
        Entity entity = new ZombieCatto();
        entity.setX(x * Constants.TILE_SIZE);
        entity.setY(y * Constants.TILE_SIZE);
        return entity;
    }

    private static Entity setArcherCatto(float x, float y) {
        Entity entity = new ArcherCatto();
        entity.setX(x * Constants.TILE_SIZE);
        entity.setY(y * Constants.TILE_SIZE);
        return entity;
    }

    public static ArrayList<Entity> loadMap1() {
        entities = new ArrayList<Entity>(20);

        return entities;
    }

    public static ArrayList<Entity> loadMap2() {
        entities = new ArrayList<Entity>(20);

        return entities;
    }

    public static ArrayList<Entity> loadMap3() {
        entities = new ArrayList<Entity>(20);

        Entity catto1 = setZombieCatto(7, 16);
        Entity catto2 = setZombieCatto(17, 16);
        Entity catto3 = setZombieCatto(13, 10);
        Entity catto4 = setZombieCatto(5, 9);
        Entity catto5 = setZombieCatto(10, 2);

        Entity catto6 = setArcherCatto(15, 2);
        Entity catto7 = setArcherCatto(18, 4);
        Entity catto8 = setArcherCatto(5, 9);

        Entity boss1 = new Boss1();
        boss1.setX(2 * Constants.TILE_SIZE);
        boss1.setY(9 * Constants.TILE_SIZE);

        entities.add(catto1);
        entities.add(catto2);
        entities.add(catto3);
        entities.add(catto4);
        entities.add(catto5);
        entities.add(catto6);
        entities.add(catto7);
        entities.add(catto8);
        entities.add(boss1);

        return entities;
    }

    public static ArrayList<Entity> loadMap4() {
        entities = new ArrayList<Entity>(20);

        Entity catto1 = setZombieCatto(9, 8);
        Entity catto2 = setZombieCatto(11, 16);
        Entity catto3 = setZombieCatto(11, 2);
        Entity catto4 = setZombieCatto(16, 7);
        Entity catto5 = setZombieCatto(2, 13);

        Entity catto6 = setArcherCatto(12, 9);
        Entity catto7 = setArcherCatto(15, 6);
        Entity catto8 = setArcherCatto(2, 3);

        Entity boss1 = new Boss2(Main.app.getGame());
        boss1.setX(14 * Constants.TILE_SIZE);
        boss1.setY(15 * Constants.TILE_SIZE);

        entities.add(catto1);
        entities.add(catto2);
        entities.add(catto3);
        entities.add(catto4);
        entities.add(catto5);
        entities.add(catto6);
        entities.add(catto7);
        entities.add(catto8);
        entities.add(boss1);

        return entities;
    }

    public static ArrayList<Entity> loadMap5() {
        entities = new ArrayList<Entity>(20);

        Entity catto1 = setZombieCatto(8, 9);
        Entity catto2 = setZombieCatto(8, 6);
        Entity catto3 = setZombieCatto(15, 4);
        Entity catto4 = setZombieCatto(2, 5);
        Entity catto5 = setZombieCatto(2, 13);
        Entity catto6 = setZombieCatto(15, 14);
        Entity catto7 = setZombieCatto(16, 14);
        Entity catto8 = setZombieCatto(11, 4);

        Entity boss = new Boss3();
        catto8.setX(3 * Constants.TILE_SIZE);
        catto8.setY(11 * Constants.TILE_SIZE);

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
        entities = new ArrayList<Entity>(20);

        Entity catto1 = setZombieCatto(8, 4);
        Entity catto2 = setZombieCatto(12, 4);
        Entity catto3 = setZombieCatto(3, 13);
        Entity catto4 = setZombieCatto(12, 3);
        Entity catto5 = setZombieCatto(3, 18);

        Entity catto6 = setArcherCatto(5, 8);
        Entity catto7 = setArcherCatto(11, 3);
        Entity catto8 = setArcherCatto(14, 13);

        Entity boss4 = new Boss4();
        boss4.setX(5 * Constants.TILE_SIZE);
        boss4.setY(3 * Constants.TILE_SIZE);

        entities.add(catto1);
        entities.add(catto2);
        entities.add(catto3);
        entities.add(catto4);
        entities.add(catto5);
        entities.add(catto6);
        entities.add(catto7);
        entities.add(catto8);
        entities.add(boss4);

        return entities;
    }
}
