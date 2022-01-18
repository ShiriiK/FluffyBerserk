package en.fluffyBerserk.game.gamecontrolls;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.maps.Map;
import en.fluffyBerserk.game.logic.maps.Map1;
import en.fluffyBerserk.game.logic.maps.PlayerSpawnManager;
import en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive.ZombieArcher;
import en.fluffyBerserk.game.logic.objects.creatures.npc.aggresive.ZombieCatto;
import en.fluffyBerserk.game.logic.objects.creatures.player.Player;
import en.fluffyBerserk.game.logic.objects.items.armor.BodyArmor;
import en.fluffyBerserk.game.logic.objects.items.armor.Head;
import en.fluffyBerserk.game.logic.objects.items.armor.Pants;
import en.fluffyBerserk.game.logic.objects.items.inventory.Inventory;
import en.fluffyBerserk.gui.screens.GameScreen;
import en.fluffyBerserk.gui.utils.Camera;
import en.fluffyBerserk.gui.utils.GameGraphics;
import en.fluffyBerserk.persistence.models.Character;


public final class Game {

    private final Player player;

    private final Inventory inventory;

    private EntityManager entityManager = new EntityManager();

    private final GameGraphics gameGraphics = new GameGraphics();

    private final GameLoop gameLoop = new GameLoop(this);

    private final Camera camera = new Camera(this);

    private Map currentMap;

    public Map map1, map2, map3, map4, map5, map6;

    public PlayerSpawnManager playerSpawner;

    public GameScreen gameScreen;

    public boolean running = false;

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
        if (currentMap.getEntities() != null){
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

        BodyArmor bodyArmor1 = new BodyArmor("bodyArmor1", 2, 2, 2, 2, ObjectType.WEARABLE);
        Head head1 = new Head("head1", 4, 2, 2, 2, ObjectType.WEARABLE);
        Pants pants1 = new Pants("pants1", 1, 2, 4, 1, ObjectType.WEARABLE);

        entityManager.addEntity(bodyArmor1);
        entityManager.addEntity(head1);
        entityManager.addEntity(pants1);

        bodyArmor1.setX(500);
        bodyArmor1.setY(500);

        head1.setX(350);
        head1.setY(350);

        pants1.setX(800);
        pants1.setY(800);

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

        map1 = new Map1();
        currentMap = map1;

    }
}
