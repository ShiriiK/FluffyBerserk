package en.fluffyBerserk.game.graphics.tiles;

import en.fluffyBerserk.game.Constants;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TileFactory {

    public static final int
            TILE_TREE1 = 0,
            TILE_TREE2 = 1,
            TILE_TREE3 = 2,

            TILE_FENCE1 = 3,
            TILE_FENCE2 = 4,
            TILE_FENCE3 = 5,
            TILE_FENCE4 = 6,
            TILE_FENCE5 = 7,
            TILE_FENCE6 = 9,
            TILE_FENCE7 = 10,
            TILE_FENCE8 = 11,

            /**TILE_BED = 13,
            TILE_PLANT1 = 14,
            TILE_PLANT2 = 15,
            TILE_PLANT3 = 16,
            TILE_POTIONS = 17,
            TILE_HERBS = 18,
            TILE_FIREPLACE = 19,
            TILE_CLOSET1 = 20,
            TILE_CLOSET2 = 21,
            TILE_CLOSET3 = 22,
            TILE_CABINET = 23,*/

            TILE_BLANK = 8,
            TILE_BLANK_WITH_COLLISION = 12;

    private static final Map<Integer, Image> tiles = new HashMap<Integer, Image>() {{
        put(TILE_TREE1, new Image("/tiles/Tree1.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_TREE2, new Image("/tiles/Tree2.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_TREE3, new Image("/tiles/Tree3.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE1, new Image("/tiles/f1.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE2, new Image("/tiles/f2.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE3, new Image("/tiles/f3.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE4, new Image("/tiles/f4.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE5, new Image("/tiles/f5.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE6, new Image("/tiles/f6.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE7, new Image("/tiles/f7.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE8, new Image("/tiles/f8.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_BLANK_WITH_COLLISION, new Image("/tiles/blank.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        /**put(TILE_BED, new Image("/tiles/bed.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_PLANT1, new Image("/tiles/plant1.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_PLANT2, new Image("/tiles/plant2.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_PLANT3, new Image("/tiles/plant3.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_POTIONS, new Image("/tiles/potions.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_HERBS, new Image("/tiles/herbs.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FIREPLACE, new Image("/tiles/fireplace.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_CLOSET1, new Image("/tiles/closet1.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_CLOSET2, new Image("/tiles/closet2.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_CLOSET3, new Image("/tiles/closet3.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_CABINET, new Image("/tiles/cabinet.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));*/

    }};



    public static @NotNull Image getRandomImage() {
        Random random = new Random();
        return tiles.get(random.nextInt(tiles.size()));
    }

    public static @NotNull Image getByIndex(int index) {
        return tiles.get(index);
    }
}
