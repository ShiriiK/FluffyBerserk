package en.fluffyBerserk.game.logic.objects.items.armor;

import en.fluffyBerserk.Constants;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ArmorImages {

    public static final int BODY1 = 0,
    HEAD1 = 1,
    PANTS1 = 2;


    private static final Map<Integer, Image> armors = new HashMap<Integer, Image>() {{
        put(BODY1, new Image("/armor/Body1.png", Constants.BASE_TILE_SIZE, Constants.BASE_TILE_SIZE, false, false));
        put(HEAD1, new Image("/armor/Head1.png", Constants.BASE_TILE_SIZE, Constants.BASE_TILE_SIZE, false, false));
        put(PANTS1, new Image("/armor/Pants1.png", Constants.BASE_TILE_SIZE, Constants.BASE_TILE_SIZE, false, false));
    }};

    public static @NotNull Image getByIndex(int index) {
        return armors.get(index);
    }
}

