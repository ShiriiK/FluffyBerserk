package en.fluffyBerserk.game;

public class Camera {

    private final Game game;

    public Camera(Game game) {
        this.game = game;
    }

    public float processX(float x) {
        float offset = game.getPlayer().getX() - ((float)Constants.SCREEN_WIDTH / 2) + ((float)Constants.TILE_SIZE / 2);

// This does not work yet, I don't know why, it looks cool but when the player comes to the bottom or left side, there is a slight bug in offset
//        if (offset <= 0F) {
//            offset = 0F;
//        } else if (offset > (Constants.WORLD_WIDTH - Constants.SCREEN_WIDTH)) {
//            offset = Constants.WORLD_WIDTH - Constants.SCREEN_WIDTH;
//        }

        return x - offset;
    }

    public float processY(float y) {
        float offset = game.getPlayer().getY() - ((float)Constants.SCREEN_HEIGHT / 2) + ((float)Constants.TILE_SIZE / 2);

// This does not work yet, I don't know why, it looks cool but when the player comes to the bottom or left side, there is a slight bug in offset
//        if (offset < 0F) {
//            offset = 0F;
//        } else if (offset > (Constants.WORLD_HEIGHT - Constants.SCREEN_HEIGHT)) {
//            offset = Constants.WORLD_HEIGHT - Constants.SCREEN_HEIGHT;
//        }

        return y - offset;
    }
}
