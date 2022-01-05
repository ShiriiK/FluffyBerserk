package en.fluffyBerserk.gui.Tile;

import en.fluffyBerserk.gui.animations.Sprite;
import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.invariables.Invariables;
import en.fluffyBerserk.invariables.Sprites;

public class TileFactory {
    private static final int def = Invariables.DEF_TILE_SIZE;

    public static void buildTiles(Tile[] tile) {
        LocateImage sprite = Sprites.grass;

        tile[0] = new Tile(); // grass
        tile[0].image = new Sprite(0, 0, def, def, sprite).getFrame();

        tile[1] = new Tile(); // grass
        tile[1].image = new Sprite(def * 2, def, def, def, sprite).getFrame();

        tile[2] = new Tile(); // grass
        tile[2].image = new Sprite(def, def * 2, def, def, sprite).getFrame();
    }
}
