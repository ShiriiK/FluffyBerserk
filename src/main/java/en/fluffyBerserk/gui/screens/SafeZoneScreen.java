package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.Tile.TileManager;
import en.fluffyBerserk.gui.animations.MovableEntityAnimations;
import en.fluffyBerserk.gui.popups.PopUpMenu;
import en.fluffyBerserk.gui.utils.AttachCSS;
import en.fluffyBerserk.invariables.Invariables;
import en.fluffyBerserk.logic.objects.creatures.Creature;
import en.fluffyBerserk.logic.objects.creatures.npc.aggresive.ZombieCatto;
import en.fluffyBerserk.logic.objects.creatures.player.Player;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * BaseScreen extension class that displays safe-zone screen.
 */

public class SafeZoneScreen extends Screen {
    private static final Player player = new Player();
    private final Canvas layer1 = new Canvas(Invariables.SCREEN_WIDTH, Invariables.SCREEN_HEIGHT);
    private final Canvas layer2 = new Canvas(Invariables.SCREEN_WIDTH, Invariables.SCREEN_HEIGHT);
    private final GraphicsContext graphicsContext1 = layer1.getGraphicsContext2D();
    private final GraphicsContext graphicsContext2 = layer2.getGraphicsContext2D();
    private boolean UP, DOWN, LEFT, RIGHT;
    private TileManager tileManager = new TileManager();
    private int imgNumber = 1;
    private int counter = 0;
    private int player_speed = 6;
    private int npc_speed = 3;
    private int dx = 0;
    private int dy = 0;

    public SafeZoneScreen() throws IOException {
    }


    @Override
    protected Scene buildScene() {
        List<ZombieCatto> npc_list = addNpcs(5);
        BorderPane root = new BorderPane();

        root.getChildren().addAll(layer1, layer2);
        layer2.toBack();

        Scene scene = new Scene(root);
        AttachCSS.attachCSS(scene);

        PopUpMenu popUpMenu = new PopUpMenu();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W:
                        UP = true;
                        break;
                    case A:
                        LEFT = true;
                        break;
                    case S:
                        DOWN = true;
                        break;
                    case D:
                        RIGHT = true;
                        break;
                    case SHIFT:
                        player_speed = 6;
                    case ESCAPE:
                        Main.app.showPopUp(popUpMenu);
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W:
                        UP = false;
                        break;
                    case A:
                        LEFT = false;
                        break;
                    case S:
                        DOWN = false;
                        break;
                    case D:
                        RIGHT = false;
                        break;
                    case SHIFT:
                        player_speed = 3;
                }
            }
        });
        AnimationTimer playerTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (UP) dy -= player_speed;
                if (DOWN) dy += player_speed;
                if (LEFT) dx -= player_speed;
                if (RIGHT) dx += player_speed;

                counter++;
                if (counter > 10) {
                    if (imgNumber == 1) {
                        imgNumber = 2;
                    } else if (imgNumber == 2) {
                        imgNumber = 3;
                    } else if (imgNumber == 3) {
                        imgNumber = 1;
                    }
                    counter = 0;
                }

                movePlayerTo(dx, dy);
                graphicsContext1.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
                tileManager.render(graphicsContext2);
                renderPlayer(graphicsContext1, dx, dy);
                renderNpcs(npc_list);
            }

        };
        playerTimer.start();
        return scene;
    }


    public List<ZombieCatto> addNpcs(int npc_count) {
        List<ZombieCatto> npc_list = new ArrayList<>();
        for (int i = 0; i < npc_count; i++) {
            ZombieCatto idk = new ZombieCatto();
            npc_list.add(idk);
        }
        return npc_list;
    }


    public void renderNpcs(List<ZombieCatto> npc_list) {
        for (ZombieCatto c : npc_list) {
            c.renderNpc(graphicsContext1, dx, dy);
        }
    }

    private void movePlayerTo(int dx, int dy) {
        if (dx == 0 && dy == 0) {
            return;
        }
        player.setX(dx);
        player.setY(dy);
    }

    private void renderPlayer(GraphicsContext graphicsContext, int dx, int dy) {
        MovableEntityAnimations playerAnimations = Player.getPlayerAnimations();

        Image image = playerAnimations.getMoveDown().get(1);
        if (UP) {
            if (imgNumber == 1) {
                image = playerAnimations.getMoveUp().get(0);
            }
            if (imgNumber == 2) {
                image = playerAnimations.getMoveUp().get(1);
            }
            if (imgNumber == 3) {
                image = playerAnimations.getMoveUp().get(2);
            }
        }
        if (DOWN) {
            if (imgNumber == 1) {
                image = playerAnimations.getMoveDown().get(0);
            }
            if (imgNumber == 2) {
                image = playerAnimations.getMoveDown().get(1);
            }
            if (imgNumber == 3) {
                image = playerAnimations.getMoveDown().get(2);
            }
        }
        if (LEFT) {
            if (imgNumber == 1) {
                image = playerAnimations.getMoveLeft().get(0);
            }
            if (imgNumber == 2) {
                image = playerAnimations.getMoveLeft().get(1);
            }
            if (imgNumber == 3) {
                image = playerAnimations.getMoveLeft().get(2);
            }
        }
        if (RIGHT) {
            if (imgNumber == 1) {
                image = playerAnimations.getMoveRight().get(0);
            }
            if (imgNumber == 2) {
                image = playerAnimations.getMoveRight().get(1);
            }
            if (imgNumber == 3) {
                image = playerAnimations.getMoveRight().get(2);
            }
        }
        graphicsContext.drawImage(image, dx, dy, Invariables.TILE_SIZE, Invariables.TILE_SIZE);
    }

    @Override
    public void onEnter() {
        System.out.println("Entered safe-zone screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left safe-zone screen");
    }

}
