package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.TileObject;
import en.fluffyBerserk.gui.graphics.tiles.TileLoader;

import java.util.Vector;

public abstract class Map {

    protected boolean locked;

    Map (){
        this.locked = isLocked();
    }

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


    public void setLocked(boolean locked){
        this.locked = locked;
    };

    public abstract String getName();

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract boolean isLocked();

    public abstract boolean isForCombat();

    public abstract Entity[] getObjects();

    public abstract int getId();
}
