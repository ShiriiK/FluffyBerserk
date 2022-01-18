package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive.ZombieCatto;

import java.util.ArrayList;

public class EntitiesForMaps {
    private static ArrayList<Entity> entities;

    /**
     * ZombieCatto catto3 = new ZombieCatto();
     * ZombieCatto catto4 = new ZombieCatto();
     * ZombieCatto catto5 = new ZombieCatto();
     * <p>
     * private static ZombieArcher archer1 = new ZombieArcher();
     * private static ZombieArcher archer2 = new ZombieArcher();
     * private static ZombieArcher archer3 = new ZombieArcher();
     * private static ZombieArcher archer4 = new ZombieArcher();
     * private static ZombieArcher archer5 = new ZombieArcher();
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

        entities.add(catto1);

        return entities;
    }

    public static ArrayList<Entity> loadMap4() {
        entities = new ArrayList<Entity>(20);

        return entities;
    }

    public static ArrayList<Entity> loadMap5(){
        entities = new ArrayList<Entity>(20);

        return entities;
    }

    public static ArrayList<Entity> loadMap6(){
        entities = new ArrayList<Entity>(20);;

        return entities;
    }
}
