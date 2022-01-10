package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.game.control.KeyManager;
import en.fluffyBerserk.gui.tile.TileManager;
import en.fluffyBerserk.gui.utils.AttachCSS;
import en.fluffyBerserk.gui.utils.GameCamera;
import en.fluffyBerserk.invariables.Constant;
import en.fluffyBerserk.invariables.Direction;
import en.fluffyBerserk.game.logic.objects.bullets.Bullet;
import en.fluffyBerserk.game.logic.objects.creatures.player.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.io.IOException;

/**
 * BaseScreen extension class that displays safe-zone screen.
 */

public class SafeZoneScreen extends BaseScreen {
    private final Player player = new Player();
    private final Canvas layer1 = new Canvas(Constant.SCREEN_WIDTH, Constant.SCREEN_HEIGHT);
    private final Canvas layer2 = new Canvas(Constant.SCREEN_WIDTH, Constant.SCREEN_HEIGHT);
    private final Canvas layer3 = new Canvas(Constant.SCREEN_WIDTH, Constant.SCREEN_HEIGHT);
    private final Image image = new Image("maps/map1.png", 1080, 1080, false, false);
    private final Image bulletImg = new Image("bullets/flufball_basic.png");
    private final GraphicsContext graphicsContext1 = layer1.getGraphicsContext2D();
    private final GraphicsContext graphicsContext2 = layer2.getGraphicsContext2D();
    private final GraphicsContext graphicsContext3 = layer3.getGraphicsContext2D();
    public Bullet playerBullet;
    private TileManager tileManager = new TileManager();
    private GameCamera gameCamera = new GameCamera(0, 0);
    private int dx = 0;
    private int dy = 0;
    private int counterShoot = 50;

    public SafeZoneScreen() throws IOException {

    }

    @Override
    protected Scene buildScene() {
        BorderPane root = new BorderPane();

        root.getChildren().addAll(layer1, layer2, layer3);
        layer2.toBack();
        layer1.toFront();

        Scene scene = new Scene(root);
        AttachCSS.attachCSS(scene);

        graphicsContext2.drawImage(image, 0, 0, Constant.WORLD_WIDTH, Constant.WORLD_HEIGHT);

        // Handles player input
        KeyManager.attachHandlers(scene);

        /**
         * Loop for updating the player
         */
        AnimationTimer playerTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                dx = 0;
                dy = 0;

                if (KeyManager.UP) {
                    dy -= player.speed;
                    player.direction = Direction.UP;
                }
                if (KeyManager.DOWN) {
                    dy += player.speed;
                    player.direction = Direction.DOWN;
                }
                if (KeyManager.LEFT) {
                    dx -= player.speed;
                    player.direction = Direction.LEFT;
                }
                if (KeyManager.RIGHT) {
                    dx += player.speed;
                    player.direction = Direction.RIGHT;
                }
                if (KeyManager.SHOOT && counterShoot >= 50) { // Bullets cooldown
                    counterShoot = 0;
                    newBullet();
                } else {
                    counterShoot++;
                }

                // Used for animations in render() method in player
                player.counter++;
                if (player.counter > 10) {
                    if (player.imgNumber == 1) {
                        player.imgNumber = 2;
                    } else if (player.imgNumber == 2) {
                        player.imgNumber = 3;
                    } else if (player.imgNumber == 3) {
                        player.imgNumber = 1;
                    }
                    player.counter = 0;
                }

                try {
                    player.move(dx, dy);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                player.renderPlayer(graphicsContext1, gameCamera);
                // Collision rect
                graphicsContext1.fillRect(player.screenHitBox.getX(), player.screenHitBox.getY(), player.screenHitBox.getWidth(), player.screenHitBox.getHeight());
                graphicsContext1.setFill(Color.RED);
            }

        };
        playerTimer.start();

        /**
         * Loop for updating background such as map and background tiles
         */
        AnimationTimer backgroundTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                renderMap(graphicsContext2);
                graphicsContext3.clearRect(0, 0, layer3.getWidth(), layer3.getHeight());
                tileManager.render(graphicsContext3, player);
            }

        };
        backgroundTimer.start();
        return scene;
    }


    private void newBullet() {
        int direction = 4;
        if (KeyManager.RIGHT) direction = 2;
        if (KeyManager.LEFT) direction = 6;
        if (KeyManager.UP) direction = 0;
        if (KeyManager.DOWN && KeyManager.RIGHT) direction = 3;
        if (KeyManager.DOWN && KeyManager.LEFT) direction = 5;
        if (KeyManager.UP && KeyManager.RIGHT) direction = 1;
        if (KeyManager.UP && KeyManager.LEFT) direction = 7;


        Bullet bullet = new Bullet(direction, player, player.getWorldX(), player.getWorldY(), graphicsContext1);
    }

    /**
     * Renders map
     * @param graphicsContext bottom canvas
     */
    private void renderMap(GraphicsContext graphicsContext) {
        graphicsContext.clearRect(0, 0, layer2.getWidth(), layer2.getHeight());
        graphicsContext.drawImage(image, layer2.getWidth() / 2 - player.getWorldX(), layer2.getHeight() / 2 - player.getWorldY(), Constant.WORLD_WIDTH, Constant.WORLD_HEIGHT);
    }
}
