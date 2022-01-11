package en.fluffyBerserk.game.logic.objects;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.graphics.tiles.TileFactory;
import javafx.scene.image.Image;

public class TileObject extends Entity {

    private final int tileIndex;

    public TileObject(int tileIndex) {
        this.tileIndex = tileIndex;
    }

    @Override
    public Image getImage() {
        return TileFactory.getByIndex(tileIndex);
    }

    @Override
    public float getWidth() {
        return Constants.TILE_SIZE;
    }

    @Override
    public float getHeight() {
        return Constants.TILE_SIZE;
    }

    public int getTileIndex() {
        return tileIndex;
    }
}
