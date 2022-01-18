package en.fluffyBerserk.game.logic.objects.bullets;

import en.fluffyBerserk.Constants;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class BulletImages {

    public static final int BULLET_BASIC = 0,
            BULLET_BLUE = 1;

    private static final Map<Integer, Image> bullets = new HashMap<Integer, Image>() {{
        put(BULLET_BASIC, new Image("/bullets/flufball_basic.png", Constants.BASE_TILE_SIZE, Constants.BASE_TILE_SIZE, false, false));
        put(BULLET_BLUE, new Image("/bullets/flufball_blue.png", Constants.BASE_TILE_SIZE, Constants.BASE_TILE_SIZE, false, false));
    }};

    public static @NotNull Image getByIndex(int index) {
        return bullets.get(index);
    }
}
