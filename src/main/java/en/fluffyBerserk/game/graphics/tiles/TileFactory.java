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


            TILE_BLANK = 8;

    private static final Map<Integer, Image> tiles = new HashMap<Integer, Image>() {{
        put(TILE_TREE1, new Image("/tiles/Tree1.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_TREE2, new Image("/tiles/Tree2.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_TREE3, new Image("/tiles/Tree3.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE1, new Image("/tiles/f1.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE2, new Image("/tiles/f2.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE3, new Image("/tiles/f3.png", Constants.TILE_SIZE/2, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE4, new Image("/tiles/f4.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE5, new Image("/tiles/f5.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE6, new Image("/tiles/f6.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE7, new Image("/tiles/f7.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_FENCE8, new Image("/tiles/f8.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
    }};



    public static @NotNull Image getRandomImage() {
        Random random = new Random();
        return tiles.get(random.nextInt(tiles.size()));
    }

    public static @NotNull Image getByIndex(int index) {
        return tiles.get(index);
    }
}
