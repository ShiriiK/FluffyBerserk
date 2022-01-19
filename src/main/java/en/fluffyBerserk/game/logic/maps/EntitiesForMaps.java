package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.creatures.npc.*;

import java.util.ArrayList;

public class EntitiesForMaps {
    private static ArrayList<Entity> entities;

    /**
     * ZombieCatto catto3 = new ZombieCatto();
     * ZombieCatto catto4 = new ZombieCatto();
     * ZombieCatto catto5 = new ZombieCatto();
     * <p>
     * private static ArcherCatto archer1 = new ArcherCatto();
     * private static ArcherCatto archer2 = new ArcherCatto();
     * private static ArcherCatto archer3 = new ArcherCatto();
     * private static ArcherCatto archer4 = new ArcherCatto();
     * private static ArcherCatto archer5 = new ArcherCatto();
     */

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

        Entity catto1 = new ZombieCatto(Main.app.getGame());
        catto1.setX(7 * Constants.TILE_SIZE);
        catto1.setY(16 * Constants.TILE_SIZE);

        Entity catto2 = new ZombieCatto(Main.app.getGame());
        catto2.setX(17 * Constants.TILE_SIZE);
        catto2.setY(16 * Constants.TILE_SIZE);

        Entity catto3 = new ZombieCatto(Main.app.getGame());
        catto3.setX(13 * Constants.TILE_SIZE);
        catto3.setY(11 * Constants.TILE_SIZE);

        Entity catto4 = new ZombieCatto(Main.app.getGame());
        catto4.setX(5 * Constants.TILE_SIZE);
        catto4.setY(9 * Constants.TILE_SIZE);

        Entity catto5 = new ZombieCatto(Main.app.getGame());
        catto5.setX(10 * Constants.TILE_SIZE);
        catto5.setY(2 * Constants.TILE_SIZE);

        Entity catto6 = new ArcherCatto(Main.app.getGame());
        catto6.setX(15 * Constants.TILE_SIZE);
        catto6.setY(2 * Constants.TILE_SIZE);

        Entity catto7 = new ArcherCatto(Main.app.getGame());
        catto7.setX(18 * Constants.TILE_SIZE);
        catto7.setY(4 * Constants.TILE_SIZE);

        Entity catto8 = new ArcherCatto(Main.app.getGame());
        catto8.setX(4 * Constants.TILE_SIZE);
        catto8.setY(9 * Constants.TILE_SIZE);

        Entity boss1 = new Boss1(Main.app.getGame());
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

        Entity catto1 = new ZombieCatto(Main.app.getGame());
        catto1.setX(9 * Constants.TILE_SIZE);
        catto1.setY(8 * Constants.TILE_SIZE);

        Entity catto2 = new ZombieCatto(Main.app.getGame());
        catto2.setX(11 * Constants.TILE_SIZE);
        catto2.setY(16 * Constants.TILE_SIZE);

        Entity catto3 = new ZombieCatto(Main.app.getGame());
        catto3.setX(11 * Constants.TILE_SIZE);
        catto3.setY(2 * Constants.TILE_SIZE);

        Entity catto4 = new ZombieCatto(Main.app.getGame());
        catto4.setX(16 * Constants.TILE_SIZE);
        catto4.setY(7 * Constants.TILE_SIZE);

        Entity catto5 = new ZombieCatto(Main.app.getGame());
        catto5.setX(2 * Constants.TILE_SIZE);
        catto5.setY(13 * Constants.TILE_SIZE);

        Entity catto6 = new ArcherCatto(Main.app.getGame());
        catto6.setX(12 * Constants.TILE_SIZE);
        catto6.setY(9 * Constants.TILE_SIZE);

        Entity catto7 = new ArcherCatto(Main.app.getGame());
        catto7.setX(15 * Constants.TILE_SIZE);
        catto7.setY(6 * Constants.TILE_SIZE);

        Entity catto8 = new ArcherCatto(Main.app.getGame());
        catto8.setX(2 * Constants.TILE_SIZE);
        catto8.setY(3 * Constants.TILE_SIZE);

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

    public static ArrayList<Entity> loadMap5(){
        entities = new ArrayList<Entity>(20);

        Entity catto1 = new ZombieCatto(Main.app.getGame());
        catto1.setX(8 * Constants.TILE_SIZE);
        catto1.setY(9 * Constants.TILE_SIZE);

        Entity catto2 = new ZombieCatto(Main.app.getGame());
        catto2.setX(8 * Constants.TILE_SIZE);
        catto2.setY(6 * Constants.TILE_SIZE);

        Entity catto3 = new ZombieCatto(Main.app.getGame());
        catto3.setX(15 * Constants.TILE_SIZE);
        catto3.setY(4 * Constants.TILE_SIZE);

        Entity catto4 = new ZombieCatto(Main.app.getGame());
        catto4.setX(2 * Constants.TILE_SIZE);
        catto4.setY(5 * Constants.TILE_SIZE);

        Entity catto5 = new ZombieCatto(Main.app.getGame());
        catto5.setX(2 * Constants.TILE_SIZE);
        catto5.setY(13 * Constants.TILE_SIZE);

        Entity catto6 = new ZombieCatto(Main.app.getGame());
        catto6.setX(15 * Constants.TILE_SIZE);
        catto6.setY(14 * Constants.TILE_SIZE);

        Entity catto7 = new ZombieCatto(Main.app.getGame());
        catto7.setX(16 * Constants.TILE_SIZE);
        catto7.setY(14 * Constants.TILE_SIZE);

        Entity catto8 = new ZombieCatto(Main.app.getGame());
        catto8.setX(11 * Constants.TILE_SIZE);
        catto8.setY(4 * Constants.TILE_SIZE);

        Entity boss = new Boss3(Main.app.getGame());
        catto8.setX(9 * Constants.TILE_SIZE);
        catto8.setY(8 * Constants.TILE_SIZE);

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

    public static ArrayList<Entity> loadMap6(){
        entities = new ArrayList<Entity>(20);;

        Entity catto1 = new ZombieCatto(Main.app.getGame());
        catto1.setX(8 * Constants.TILE_SIZE);
        catto1.setY(4 * Constants.TILE_SIZE);

        Entity catto2 = new ZombieCatto(Main.app.getGame());
        catto2.setX(12 * Constants.TILE_SIZE);
        catto2.setY(4 * Constants.TILE_SIZE);

        Entity catto3 = new ZombieCatto(Main.app.getGame());
        catto3.setX(3 * Constants.TILE_SIZE);
        catto3.setY(13 * Constants.TILE_SIZE);

        Entity catto4 = new ZombieCatto(Main.app.getGame());
        catto4.setX(12 * Constants.TILE_SIZE);
        catto4.setY(3 * Constants.TILE_SIZE);

        Entity catto5 = new ZombieCatto(Main.app.getGame());
        catto5.setX(3 * Constants.TILE_SIZE);
        catto5.setY(18 * Constants.TILE_SIZE);

        Entity catto6 = new ArcherCatto(Main.app.getGame());
        catto6.setX(5 * Constants.TILE_SIZE);
        catto6.setY(8 * Constants.TILE_SIZE);

        Entity catto7 = new ArcherCatto(Main.app.getGame());
        catto7.setX(11 * Constants.TILE_SIZE);
        catto7.setY(3 * Constants.TILE_SIZE);

        Entity catto8 = new ArcherCatto(Main.app.getGame());
        catto8.setX(14 * Constants.TILE_SIZE);
        catto8.setY(13 * Constants.TILE_SIZE);

        Entity boss4 = new Boss4(Main.app.getGame());
        catto8.setX(14 * Constants.TILE_SIZE);
        catto8.setY(4 * Constants.TILE_SIZE);

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
