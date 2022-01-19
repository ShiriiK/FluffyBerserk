package en.fluffyBerserk.gui.graphics.tiles;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.TileObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public final class TileLoader {

    /**
     * Loads tiles to vector for specific map
     *
     * @param path to the file of the tiles
     * @return 2D vector containing objects which identify tiles
     */
    public static Vector<Vector<TileObject>> loadTiles(String path, int width, int height) {
        int maxRow = height/Constants.TILE_SIZE;
        int maxCol = width/Constants.TILE_SIZE;
        Vector<Vector<TileObject>> matrix = new Vector<>(maxRow);
        Vector<Vector<TileObject>> spawnable= new Vector<>(maxRow);

        try {
            InputStream inputStream = TileLoader.class.getClassLoader().getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int row = 0;

            while (row < maxRow) {
                String[] tiles = reader.readLine().split(" ");
                int col = 0;

                Vector<TileObject> colMatrix = new Vector<>(maxCol);

                while (col < maxCol) {
                    int tileNumber = Integer.parseInt(tiles[col]);

                    if (tileNumber != TileFactory.TILE_BLANK) {
                        TileObject tileObject = new TileObject(Integer.parseInt(tiles[col]), ObjectType.TILE);

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
