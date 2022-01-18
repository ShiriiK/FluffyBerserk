package en.fluffyBerserk.gui.graphics.objects;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.portals.HomePortal;

public class ObjectsForMap {

    private static Entity[] object;

    public static Entity[] loadObjects(int mapNumber) {

        switch (mapNumber) {
            case 1:
                return loadMap1();
            case 2:
                return loadMap2();
            case 3:
                return loadMap3();
            case 4:
                return loadMap4();
            case 6:
                return loadMap6();
        }
        return object;
    }

    private static Entity[] loadMap6() {
        object = new Entity[1];

        object[0] = new HomePortal();
        object[0].setX(950);
        object[0].setY(1300);

        return object;
    }

    private static Entity[] loadMap4() {
        object = new Entity[1];

        object[0] = new HomePortal();
        object[0].setX(3 * Constants.TILE_SIZE);
        object[0].setY((float) (15 * Constants.TILE_SIZE));

        return object;
    }

    private static Entity[] loadMap3() {
        object = new Entity[5];

        object[0] = new HomePortal();
        object[0].setX(3 * Constants.TILE_SIZE);
        object[0].setY((float) (15 * Constants.TILE_SIZE));

        object[1] = EntityFactory.catStatueFront;
        object[1].setX(7 * Constants.TILE_SIZE);
        object[1].setY((float) (11.5 * Constants.TILE_SIZE));

        object[2] = EntityFactory.catStatueRight;
        object[2].setX(3 * Constants.TILE_SIZE);
        object[2].setY((float) (6.5 * Constants.TILE_SIZE));

        object[3] = EntityFactory.catStatueBack;
        object[3].setX(9 * Constants.TILE_SIZE);
        object[3].setY((float) (5.5 * Constants.TILE_SIZE));

        object[4] = EntityFactory.catStatueLeft;
        object[4].setX(17 * Constants.TILE_SIZE);
        object[4].setY((float) (7.5 * Constants.TILE_SIZE));

        return object;
    }

    private static Entity[] loadMap2() {
        object = new Entity[14];

        object[0] = EntityFactory.carpet;
        object[0].setX((float) (Constants.TILE_SIZE * 4.5));
        object[0].setY((float) (Constants.TILE_SIZE * 8));

        object[1] = EntityFactory.bed;
        object[1].setX((float) (Constants.TILE_SIZE * 8));
        object[1].setY((float) ( Constants.TILE_SIZE * 2));

        object[2] = EntityFactory.closet;
        object[2].setX((float) (Constants.TILE_SIZE * 4));
        object[2].setY((float) ( Constants.TILE_SIZE * 1.5));

        object[3] = EntityFactory.plant;
        object[3].setX((float) (Constants.TILE_SIZE * 5.25));
        object[3].setY((float) ( Constants.TILE_SIZE *1.75));

        object[4] = EntityFactory.library;
        object[4].setX((float) (Constants.TILE_SIZE * 6));
        object[4].setY((float) ( Constants.TILE_SIZE * 5));

        object[5] = EntityFactory.cabinet;
        object[5].setX((float) (Constants.TILE_SIZE * 2));
        object[5].setY((float) ( Constants.TILE_SIZE * 4));

        object[6] = EntityFactory.herbs;
        object[6].setX((float) (Constants.TILE_SIZE * 3));
        object[6].setY((float) ( Constants.TILE_SIZE * 4));

        object[7] = EntityFactory.fireplace;
        object[7].setX((float) (Constants.TILE_SIZE * 7));
        object[7].setY((float) ( Constants.TILE_SIZE * 4.5));

        object[8] = EntityFactory.armchair;
        object[8].setX((float) (Constants.TILE_SIZE * 8.25));
        object[8].setY((float) ( Constants.TILE_SIZE * 6.5));

        object[9] = EntityFactory.table;
        object[9].setX((float) (Constants.TILE_SIZE * 1.5));
        object[9].setY((float) ( Constants.TILE_SIZE * 7));

        object[10] = EntityFactory.boxes;
        object[10].setX((float) (Constants.TILE_SIZE));
        object[10].setY((float) ( Constants.TILE_SIZE * 4));

        object[11] = EntityFactory.plant2;
        object[11].setX((float) (Constants.TILE_SIZE * 8.25));
        object[11].setY((float) ( Constants.TILE_SIZE * 5.5));

        object[12] = EntityFactory.chair;
        object[12].setX((float) (Constants.TILE_SIZE * 2));
        object[12].setY((float) ( Constants.TILE_SIZE * 6.5));

        object[13] = EntityFactory.potions;
        object[13].setX((float) (Constants.TILE_SIZE * 6));
        object[13].setY((float) ( Constants.TILE_SIZE * 1.75));

        return object;
    }

    private static Entity[] loadMap1() {
        object = new Entity[2];

        object[0] = new HomePortal();
        object[0].setX(17 * Constants.TILE_SIZE);
        object[0].setY((float) (6.5 * Constants.TILE_SIZE));

        object[1] = EntityFactory.home;
        object[1].setX(Constants.TILE_SIZE*5);
        object[1].setY(0);

        return object;
    }


}
