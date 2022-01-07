package en.fluffyBerserk.gui.Tile;

import en.fluffyBerserk.gui.animations.SpriteImage;
import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.invariables.Invariables;
import en.fluffyBerserk.gui.animations.SpritesFactory;

/**
 * Class for keeping and managing existing tiles for world building
 */
public class TileFactory {
    private static final int def = Invariables.DEF_TILE_SIZE;

    public static void buildTiles(Tile[] tile) {
        LocateImage sprite = SpritesFactory.grass;

        tile[0] = new Tile(); // grass
        tile[0].image = new SpriteImage(sprite, 0, 0, def, def).getFrame();

        tile[1] = new Tile(); // grass
        tile[1].image = new SpriteImage(sprite, def * 2, def, def, def).getFrame();

        tile[2] = new Tile(); // grass
        tile[2].image = new SpriteImage(sprite, def, def * 2, def, def).getFrame();
    }
}
