package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.animations.MovableEntityAnimations;
import en.fluffyBerserk.gui.popups.PopUpMenu;
import en.fluffyBerserk.invariables.Invariables;
import en.fluffyBerserk.logic.objects.creatures.player.Player;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;

/**
 * BaseScreen extension class that displays safe-zone screen.
 */

public class SafeZoneScreen extends BaseScreen {
    private boolean UP, DOWN, LEFT, RIGHT;
    private final Canvas canvas = new Canvas(Invariables.SCREEN_WIDTH, Invariables.SCREEN_HEIGHT);
    private final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    private static Player player = new Player();
    private int imgNumber = 1;
    private int counter = 0;
    private int speed = 3;
    private int dx = 0;
    private int dy = 0;


    @Override
    protected Scene buildScene() {
        BorderPane root = new BorderPane();


        root.getChildren().add(canvas);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("fluf.css");



        PopUpMenu popUpMenu = new PopUpMenu();
        Popup menuPopUp = popUpMenu.getPopUp();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W: UP = true; break;
                    case A: LEFT = true; break;
                    case S: DOWN = true; break;
                    case D: RIGHT = true; break;
                    case SHIFT: speed = 6;
                    case ESCAPE:
                        popUpCenter.centerPopUp(menuPopUp);

                        Main.app.showPopUp(popUpMenu);
                        menuPopUp.show(Main.app.getPrimaryStage());
                        System.out.println("Menu popup");
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W: UP = false; break;
                    case A: LEFT = false; break;
                    case S: DOWN = false; break;
                    case D: RIGHT = false; break;
                    case SHIFT: speed = 3;
                }
            }
        });

        AnimationTimer playerTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(UP) dy-=speed;
                if(DOWN) dy+=speed;
                if(LEFT) dx-=speed;
                if(RIGHT) dx+=speed;

                counter ++;
                if(counter > 10){
                    if(imgNumber == 1){
                        imgNumber = 2;
                    } else if (imgNumber == 2){
                        imgNumber = 3;
                    } else if (imgNumber == 3){
                        imgNumber = 1;
                    }
                    counter = 0;
                }

                movePlayerTo(dx, dy);
                renderPlayer(graphicsContext, dx, dy);
            }

        };
        playerTimer.start();
        return scene;
    }

    private void movePlayerTo(int dx, int dy) {
        if (dx == 0 && dy == 0){
            return;
        }
        player.setX(dx);
        player.setY(dy);

    }

    private void renderPlayer( GraphicsContext graphicsContext, int dx, int dy) {
        MovableEntityAnimations playerAnimations = player.getPlayerAnimations();
        Image image = playerAnimations.getMoveDown().get(1);
            if(UP){
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
            if(DOWN) {
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
            if(LEFT) {
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
            if(RIGHT){
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
            graphicsContext.clearRect(0,0,canvas.getWidth(), canvas.getHeight());
            graphicsContext.drawImage(image, dx, dy, Invariables.TILE_SIZE*2, Invariables.TILE_SIZE*2);
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
