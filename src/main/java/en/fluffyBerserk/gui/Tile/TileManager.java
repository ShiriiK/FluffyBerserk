package en.fluffyBerserk.gui.Tile;

import en.fluffyBerserk.invariables.Invariables;
import javafx.scene.canvas.GraphicsContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    private static final int cols = Invariables.MAX_SCREEN_COL;
    private static final int rows = Invariables.MAX_SCREEN_ROW;
    private static final int scale = Invariables.TILE_SIZE;
    private Tile[] tile;
    private int tileNumber[][];

    public TileManager() throws IOException {
        tile = new Tile[20];
        tileNumber = new int[cols][rows];

        TileFactory.buildTiles(tile);
        loadMap("/maps/map1.txt");
    }

    private void loadMap(String path) throws IOException {
        try {
            InputStream inputStream = getClass().getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

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

    public void render(GraphicsContext graphicsContext) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < cols && row < rows) {
            int tileNum = tileNumber[col][row];
            graphicsContext.drawImage(tile[tileNum].image, x, y, scale, scale);
            col++;
            x += TileManager.scale;

            if (col == cols) {
                col = 0;
                x = 0;
                row++;
                y += TileManager.scale;
            }
        }
    }

}
