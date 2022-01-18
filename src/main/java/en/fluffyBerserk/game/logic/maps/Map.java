package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.TileObject;
import en.fluffyBerserk.gui.graphics.tiles.TileLoader;

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

    public Map loadMapById(int mapId) {
        switch (mapId) {
            case 1:
                return new Map1();
            case 2:
                return new Map2();
            case 3:
                return new Map3();
            case 4:
                return new Map4();
            case 6:
                return new Map6();
        }
        return new Map1();
    }

    public abstract String getName();

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract boolean isForCombat();

    public abstract Entity[] getObjects();

    public abstract int getId();
}
