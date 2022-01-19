package en.fluffyBerserk.gui.graphics.sprites;

import en.fluffyBerserk.gui.utils.LocateImage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Class for keeping and managing existing sprites
 */
public class SpritesFactory {


    private static final Map<Integer, LocateImage> skins = new HashMap<Integer, LocateImage>() {{
        put(0, new LocateImage("player/fluf1.png", 0));
        put(1, new LocateImage("player/fluf2.png", 1));
        put(2, new LocateImage("player/fluf3.png", 2));
        put(3, new LocateImage("player/fluf4.png", 3));
        put(4, new LocateImage("player/fluf5.png", 4));
        put(5, new LocateImage("player/fluf6.png", 5));
        put(6, new LocateImage("player/fluf7.png", 6));
        put(7, new LocateImage("player/fluf8.png", 7));
        put(8, new LocateImage("player/fluf9.png", 8));
        put(9, new LocateImage("player/fluf10.png", 9));
        put(10, new LocateImage("player/fluf11.png", 10));
        put(11, new LocateImage("player/fluf12.png", 11));
        put(12, new LocateImage("player/fluf13.png", 12));



    }};

    private static final Map<Integer, LocateImage> meleeEnemies = new HashMap<Integer, LocateImage>() {{
        put(0, new LocateImage("npcs/melee1.png", 0));
        put(1, new LocateImage("npcs/melee2.png", 1));
        put(2, new LocateImage("npcs/melee3.png", 2));
    }};

    private static final Map<Integer, LocateImage> rangedEnemies = new HashMap<Integer, LocateImage>() {{
        put(0, new LocateImage("npcs/ranged1.png", 1));
    }};



    public static boolean indexExists(Integer key) {
        return skins.containsKey(key);
    }

    public static @NotNull Map<Integer, LocateImage> getSkins() {
        return skins;
    }

    public static @NotNull LocateImage getRandomSprite() {
        Random random = new Random();
        return skins.get(random.nextInt(skins.size()));
    }
    public static @NotNull LocateImage getRandomMeleeEnemySprite() {
        Random random = new Random();
        return meleeEnemies.get(random.nextInt(meleeEnemies.size()));
    }
    public static @NotNull LocateImage getRandomRangedEnemySprite() {
        Random random = new Random();
        return rangedEnemies.get(random.nextInt(rangedEnemies.size()));
    }


    public static @Nullable LocateImage getSpriteByNumber(Integer key) {
        return skins.get(key);
    }
}
