package en.fluffyBerserk.game;

public class Constants {

    public static final float BASE_TILE_SIZE = 32F;

    public static final float SCALE = 2F;

    public static final float TILE_SIZE = SCALE * BASE_TILE_SIZE;

    public static final float ENTITIES_SIZE = TILE_SIZE - 10;

    public static final int MAX_WORLD_COL = 20;
    public static final int MAX_WORLD_ROW = 20;

    public static final float WORLD_WIDTH = TILE_SIZE * MAX_WORLD_COL;
    public static final float WORLD_HEIGHT = TILE_SIZE * MAX_WORLD_ROW;

    public static final int MAX_SCREEN_COL = 16;
    public static final int MAX_SCREEN_ROW = 12;

    public static final float SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    public static final float SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;

    public static boolean SHOW_HIT_BOX = true;
}
