package en.fluffyBerserk.game;

import en.fluffyBerserk.game.graphics.GameGraphics;
import en.fluffyBerserk.game.logic.objects.creatures.player.Player;
import en.fluffyBerserk.game.maps.Map;
import en.fluffyBerserk.game.maps.SafeZoneMap;
import en.fluffyBerserk.persistence.models.Character;

public final class Game {

    private final Player player;

    private final EntityManager entityManager = new EntityManager();

    private final GameGraphics gameGraphics = new GameGraphics();

    private final GameLoop gameLoop = new GameLoop(this);

    private final Camera camera = new Camera(this);

    private Map currentMap;

    public Game(Character character) {
        player = new Player(character);
        bootDefaultState();
    }

    public Camera getCamera() {
        return camera;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Player getPlayer() {
        return player;
    }

    public GameGraphics getGameGraphics() {
        return gameGraphics;
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

    private void bootDefaultState() {
        entityManager.addEntity(player);

        // Spawn player in the center of current map
        player.setX(((float)Constants.WORLD_WIDTH / 2) - ((float)Constants.TILE_SIZE / 2));
        player.setY(((float)Constants.WORLD_HEIGHT / 2) - ((float)Constants.TILE_SIZE / 2));

        currentMap = new SafeZoneMap();
    }
}
