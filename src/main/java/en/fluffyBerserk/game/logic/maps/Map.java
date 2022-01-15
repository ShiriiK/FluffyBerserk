package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.gui.graphics.tiles.TileLoader;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.TileObject;

import java.util.Vector;

public abstract class Map {

    private final Vector<Vector<TileObject>> tiles = TileLoader.loadTiles(getTilePath(), getWidth(), getHeight());

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

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract Entity[] getObjects();
}
