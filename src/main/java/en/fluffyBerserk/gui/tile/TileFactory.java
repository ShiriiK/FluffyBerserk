package en.fluffyBerserk.gui.tile;
import javafx.scene.image.Image;
/**
 * Class for keeping and managing existing tiles for world building
 */
public class TileFactory {

    public void buildTiles(Tile[] tile) {
        // Tree
        tile[0] = new Tile(); // tree
        tile[0].image = new Image("/tiles/Tree2.png", 32, 32, false, false);
        tile[0].setCollision(true);

        tile[1] = new Tile(); // tree
        tile[1].image = new Image("/tiles/Tree2.png", 32, 32, false, false);
        tile[1].setCollision(true);

        tile[2] = new Tile(); // tree
        tile[2].image = new Image("/tiles/Tree3.png", 32, 32, false, false);
        tile[2].setCollision(true);

        tile[8] = new Tile(); // grass flower
        tile[8].image = new Image("/tiles/blank.png", 32, 32, false, false);
    }
}
