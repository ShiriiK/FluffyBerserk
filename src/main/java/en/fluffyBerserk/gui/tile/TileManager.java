package en.fluffyBerserk.gui.tile;

import en.fluffyBerserk.invariables.Constant;
import en.fluffyBerserk.game.logic.objects.creatures.player.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Class where loading and rendering of map takes place
 */
public class TileManager {
    private static final int cols = Constant.MAX_WORLD_COL;
    private static final int rows = Constant.MAX_WORLD_ROW;
    private static final int scale = Constant.TILE_SIZE;
    public Tile[] tile;
    public int tileNumber[][];
    private TileFactory tileFactory = new TileFactory();
    public ArrayList<Rectangle> rectangleArrayList = new ArrayList<>(400);

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
     * Renders tiles on screen
     * @param graphicsContext gc to which tiles will be drawn to
     */
    public void render(GraphicsContext graphicsContext, Player player) {
        int col = 0;
        int row = 0;
        rectangleArrayList.clear();

        while (col < cols && row < rows) {
            int tileNum = tileNumber[col][row];
            if(tileNum != 8){
                int worldX = col * Constant.TILE_SIZE;
                int worldY = row * Constant.TILE_SIZE;
                int screenX = (int) (worldX - player.getWorldX() + Player.screenX);
                int screenY = (int) (worldY - player.getWorldY() + Player.screenY);

                if(!(screenX < -Constant.TILE_SIZE) && !(screenY < -Constant.TILE_SIZE)){
                    graphicsContext.drawImage(tile[tileNum].image, screenX, screenY, scale, scale);
                    //graphicsContext.fillRect(screenX, screenY, scale, scale)
                    rectangleArrayList.add(new Rectangle(screenX, screenY, scale, scale));
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
