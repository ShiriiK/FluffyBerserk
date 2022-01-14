package en.fluffyBerserk.game.graphics.objects;
;
import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.animations.SpriteImage;
import en.fluffyBerserk.game.animations.SpritesFactory;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {

    public static final int
            TILE_PORTAL1 = 0,
            TILE_PORTAL2 = 1,
            TILE_PORTAL3 = 2,
            TILE_PORTAL4 = 3;

    private static final Map<Integer, Image> objects = new HashMap<Integer, Image>(){{
        put(TILE_PORTAL1, new SpriteImage(SpritesFactory.getObjectSpriteByNumber(0),0 , 0, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());
        put(TILE_PORTAL2, new SpriteImage(SpritesFactory.getObjectSpriteByNumber(0),Constants.TILE_SIZE , 0, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());
        put(TILE_PORTAL3, new SpriteImage(SpritesFactory.getObjectSpriteByNumber(0), 2*Constants.TILE_SIZE, 0, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());
        put(TILE_PORTAL4, new SpriteImage(SpritesFactory.getObjectSpriteByNumber(0), 3*Constants.TILE_SIZE, 0, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());

    }};

    public static @NotNull Image getByIndex(int index) {
        return objects.get(index);
    }
}
