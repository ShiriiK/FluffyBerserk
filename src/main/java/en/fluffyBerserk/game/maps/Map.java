package en.fluffyBerserk.game.maps;

import en.fluffyBerserk.game.graphics.tiles.TileLoader;
import en.fluffyBerserk.game.logic.objects.AnimatedEntity;
import en.fluffyBerserk.game.logic.objects.TileObject;

import java.util.Vector;

public abstract class Map {

    private final Vector<Vector<TileObject>> tiles = TileLoader.loadTiles(getTilePath());

    public Vector<Vector<TileObject>> getTiles() {
        return tiles;
    }

    public String getTilePath() {
        return String.format("maps/%s.txt", getName());
    }

    public String getImagePath() {
        return String.format("maps/%s.png", getName());
    }

    public abstract String getName();

    public abstract AnimatedEntity[] getObjects();
}
