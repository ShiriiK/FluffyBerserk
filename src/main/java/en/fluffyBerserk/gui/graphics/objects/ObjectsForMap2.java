package en.fluffyBerserk.gui.graphics.objects;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;

public class ObjectsForMap2 {

    public static Entity[] loadObjects() {
        Entity object[] = new Entity[14];

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
}
