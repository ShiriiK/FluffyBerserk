package en.fluffyBerserk.gui.graphics.tiles;

import en.fluffyBerserk.Constants;
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

            TILE_BLANK = 8,
            TILE_BLANK_WITH_COLLISION = 12;

    private static final Map<Integer, Image> tiles = new HashMap<Integer, Image>() {{
        put(TILE_TREE1, new Image("/tiles/Tree1.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_TREE2, new Image("/tiles/Tree2.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_TREE3, new Image("/tiles/Tree3.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));
        put(TILE_BLANK_WITH_COLLISION, new Image("/tiles/blank.png", Constants.TILE_SIZE, Constants.TILE_SIZE, false, false));

    }};



    public static @NotNull Image getRandomImage() {
        Random random = new Random();
        return tiles.get(random.nextInt(tiles.size()));
    }

    public static @NotNull Image getByIndex(int index) {
        return tiles.get(index);
    }
}
