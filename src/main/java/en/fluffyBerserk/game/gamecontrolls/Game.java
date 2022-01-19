package en.fluffyBerserk.game.gamecontrolls;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.maps.Map;
import en.fluffyBerserk.game.logic.maps.MapLoader;
import en.fluffyBerserk.game.logic.maps.PlayerSpawnManager;
import en.fluffyBerserk.game.logic.objects.creatures.player.Player;
import en.fluffyBerserk.game.logic.objects.items.inventory.Inventory;
import en.fluffyBerserk.gui.screens.GameScreen;
import en.fluffyBerserk.gui.utils.Camera;
import en.fluffyBerserk.gui.utils.GameGraphics;
import en.fluffyBerserk.persistence.models.Character;


public final class Game {

    private final Player player;

    private final Inventory inventory;
    private final GameGraphics gameGraphics = new GameGraphics();
    private final GameLoop gameLoop = new GameLoop(this);
    private final Camera camera = new Camera(this);
    public Map map1, map2, map3, map4, map5, map6;
    public PlayerSpawnManager playerSpawner;
    public GameScreen gameScreen;
    public boolean running = false;
    private EntityManager entityManager = new EntityManager();
    private Map currentMap;

    public Game(Character character) {
        player = new Player(character);
        inventory = new Inventory(character);
        playerSpawner = new PlayerSpawnManager(this);
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

    public void setCurrentMap(Map map) {
        if (currentMap.getEntities() != null) {
            this.getEntityManager().removeEntites(currentMap.getEntities());
        }
        currentMap = map;
        if (currentMap.getEntities() != null) {
            this.getEntityManager().addEntites(currentMap.getEntities());
        }
    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

    public Inventory getInventory() {
        return inventory;
    }

    private void bootDefaultState() {
        entityManager.addEntity(player);

        // Spawn player on defined spawn location at last save location
        if (player.getCharacter().getLastX() == 0 && player.getCharacter().getLastY() == 0) {
            player.setX(((float) 13 * Constants.TILE_SIZE));
            player.setY(((float) 7 * Constants.TILE_SIZE));
        } else {
            player.setX(player.getCharacter().getLastX());
            player.setY(player.getCharacter().getLastY());
        }
        player.setHitBoxX(player.getX() + 20);
        player.setHitBoxY(player.getY() + 30);

        currentMap = MapLoader.loadMapById(player.getCharacter().getLastMapId());
    }
}
