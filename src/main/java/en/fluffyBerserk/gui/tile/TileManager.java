package en.fluffyBerserk.gui.tile;

import en.fluffyBerserk.invariables.Constant;
import en.fluffyBerserk.logic.objects.creatures.player.Player;
import javafx.scene.canvas.GraphicsContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class where loading and rendering of map takes place
 */
public class TileManager {
    private static final int cols = Constant.MAX_WORLD_COL;
    private static final int rows = Constant.MAX_WORLD_ROW;
    private static final int scale = Constant.TILE_SIZE;
    private Tile[] tile;
    private int tileNumber[][];
    private TileFactory tileFactory = new TileFactory();

    public TileManager() throws IOException {
        tile = new Tile[20];
        tileNumber = new int[cols][rows];

        tileFactory.buildTiles(tile);
        loadMap("/maps/map1.txt");
    }

    /**
     * Reads text file
     * @param path desired map for loading
     */
    private void loadMap(String path) throws IOException {
        try {
            InputStream inputStream = getClass().getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

            // Reads the max columns and rows defined in invariables for screen
            while (col < cols && row < rows) {
                String line = reader.readLine();

                while (col < cols) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);


                    tileNumber[col][row] = num;
                    col++;
                }
                if (col == cols) {
                    col = 0;
                    row++;
                }
            }
            reader.close();

        } catch (Exception e) {

        }

    }

    /**
     * Renders information given by loadMap method
     * @param graphicsContext gc to which map will be rendered to, in this case its gc for canvas that is in bottom of other canvases
     */
    public void render(GraphicsContext graphicsContext, Player player) {
        int col = 0;
        int row = 0;

        while (col < cols && row < rows) {
            int tileNum = tileNumber[col][row];
            if(tileNum != 8){
                int worldX = col * Constant.TILE_SIZE;
                int worldY = row * Constant.TILE_SIZE;
                int screenX = (int) (worldX - player.getWorldX() + Player.screenX +30);
                int screenY = (int) (worldY - player.getWorldY() + Player.screenY +28);

                if(!(screenX < -Constant.TILE_SIZE) && !(screenY < -Constant.TILE_SIZE)){
                    graphicsContext.drawImage(tile[tileNum].image, screenX, screenY, scale, scale);
                }


            }
            col++;

            if (col == cols) {
                col = 0;
                row++;
            }
        }
    }

}
