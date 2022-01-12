package en.fluffyBerserk.game.graphics.tiles;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.logic.objects.TileObject;

import java.io.*;
import java.util.Vector;

public final class TileLoader {

    /**
     * Loads tiles to vector for specific map
     *
     * @param path to the file of the tiles
     * @return 2D vector containing objects which identify tiles
     */
    public static Vector<Vector<TileObject>> loadTiles(String path) {
        Vector<Vector<TileObject>> matrix = new Vector<>(Constants.MAX_WORLD_ROW);

        try {
            InputStream inputStream = TileLoader.class.getClassLoader().getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int row = 0;

            while (row < Constants.MAX_WORLD_ROW) {
                String[] tiles = reader.readLine().split(" ");
                int col = 0;

                Vector<TileObject> colMatrix = new Vector<>(Constants.MAX_WORLD_COL);

                while (col < Constants.MAX_WORLD_COL) {
                    int tileNumber = Integer.parseInt(tiles[col]);

                    if (tileNumber != TileFactory.TILE_BLANK) {
                        TileObject tileObject = new TileObject(Integer.parseInt(tiles[col]));

                        tileObject.setX(col * tileObject.getWidth());
                        tileObject.setY(row * tileObject.getHeight());

                        colMatrix.add(tileObject);
                    } else {
                        colMatrix.add(null);
                    }
                    col++;
                }

                matrix.add(colMatrix);
                row++;
            }

            reader.close();

            return matrix;
        } catch (IOException exception) {
            throw new RuntimeException("Failed to load tile map!");
        }
    }
}
