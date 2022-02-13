package en.fluffyBerserk;

import javafx.scene.image.Image;

public class Constants {

    public static final String APP_NAME = "Fluffy Berserk";
    public static final Image APP_ICON = new Image("/icon/icon.png");

    public static final int BASE_TILE_SIZE = 32;

    public static final int SCALE = 2;

    public static final int TILE_SIZE = SCALE * BASE_TILE_SIZE;

    public static final int ENTITIES_SIZE = TILE_SIZE - 10;

    public static final int PLAYER_HP_SCALE = 20;       //Hp = stamina(or vitality) * this constant
    public static final int PLAYER_DMG_SCALE = 100;       //Dmg = strength * this constant

    public static final int MAX_WORLD_COL = 20;
    public static final int MAX_WORLD_ROW = 20;

    public static final int WORLD_WIDTH = TILE_SIZE * MAX_WORLD_COL;
    public static final int WORLD_HEIGHT = TILE_SIZE * MAX_WORLD_ROW;

    public static final int MAX_SCREEN_COL = 16;
    public static final int MAX_SCREEN_ROW = 12;

    public static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    public static final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;

    public static final int DROP_RATE = 20;
    public static final int NUMBER_OF_POTIONS = 4;

    public static boolean SHOW_HIT_BOX = true;

}
