package en.fluffyBerserk.base;

import en.fluffyBerserk.gui.gamecontroller.KeyPressHandler;
import en.fluffyBerserk.gui.gamecontroller.KeyReleaseHandler;
import en.fluffyBerserk.invariables.Invariables;
import en.fluffyBerserk.logic.objects.creatures.player.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
;

public class GamePanel extends Pane implements Runnable {

    private KeyPressHandler keyPressHandler = new KeyPressHandler();
    private KeyReleaseHandler keyReleaseHandler = new KeyReleaseHandler();
    private Player player = new Player(this, keyReleaseHandler, keyPressHandler);

    private final Canvas canvas = new Canvas();
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    private Thread gameThread;
    private int FPS = 60;


    public GamePanel() {
        this.setPrefSize(Invariables.SCREEN_WIDTH, Invariables.SCREEN_HEIGHT);
        this.addEventHandler(KeyEvent.KEY_PRESSED, keyPressHandler);
        this.addEventHandler(KeyEvent.KEY_RELEASED, keyReleaseHandler);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * GAME LOOP
     */
    @Override
    public void run() {
        double renderInterval = 1000000000 / FPS;
        double accumulator = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        long timer = 0;
        int renderCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            accumulator += (currentTime - lastTime) / renderInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (accumulator >= 1) {
                update();
                render();
                accumulator--;
                renderCount++;
            }


            if (timer >= 1000000000) {
                System.out.println("FPS: " + renderCount);
                renderCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void render(){
        graphicsContext.save();
        player.render(graphicsContext);
        graphicsContext.restore();
    }

}
