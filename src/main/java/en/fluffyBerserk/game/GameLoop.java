package en.fluffyBerserk.game;

import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.MovableEntity;
import en.fluffyBerserk.game.logic.Collision;
import en.fluffyBerserk.game.logic.objects.TileObject;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.util.Vector;

public final class GameLoop {

    @NotNull
    private final Game game;

    @NotNull
    private final AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            updateGame();
        }
    };

    public GameLoop(@NotNull Game game) {
        this.game = game;
    }

    public void start() {
        timer.start();
    }

    private void updateGame() {
        Canvas gameCanvas = game.getGameGraphics().getCanvas();

        // Clear the whole canvas
        gameCanvas.getGraphicsContext2D().clearRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());

        drawMap(gameCanvas);

        drawTiles(gameCanvas);

        drawEntities(gameCanvas);
    }

    private void drawMap(Canvas canvas) {
        Image mapImage = new Image(game.getCurrentMap().getImagePath(), Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, false, false);

        canvas.getGraphicsContext2D().drawImage(
                mapImage,
                game.getCamera().processX(0),
                game.getCamera().processY(0),
                Constants.WORLD_WIDTH,
                Constants.WORLD_HEIGHT
        );
    }

    private void drawTiles(Canvas canvas) {
        Vector<Vector<TileObject>> tiles = game.getCurrentMap().getTiles();

        for (Vector<TileObject> tileObjects : tiles) {
            for (TileObject tile : tileObjects) {
                if (tile == null) { // blank tile
                    continue;
                }

                canvas.getGraphicsContext2D().drawImage(
                        tile.getImage(),
                        game.getCamera().processX(tile.getX()),
                        game.getCamera().processY(tile.getY()),
                        tile.getWidth(),
                        tile.getHeight()
                );

                if (Constants.SHOW_HIT_BOX) {
                    canvas.getGraphicsContext2D().strokeRect(
                            game.getCamera().processX(tile.getX()),
                            game.getCamera().processY(tile.getY()),
                            tile.getWidth(),
                            tile.getHeight()
                    );
                }
            }
        }
    }

    private void drawEntities(Canvas canvas) {
        for (Entity entity : game.getEntityManager().getEntities()) {
            if (!(entity instanceof MovableEntity)) {
                continue;
            }

            ((MovableEntity) entity).move();

            // Check collision with tiles
            Vector<Vector<TileObject>> tiles = game.getCurrentMap().getTiles();
            outerFor:
            for (Vector<TileObject> tileObjects : tiles) {
                for (TileObject tile : tileObjects) {
                    if (tile == null) { // blank tile
                        continue;
                    }

                    if (Collision.objectsCollide(tile, entity)) {
                        entity.setX(entity.getPreviousX());
                        entity.setY(entity.getPreviousY());
                        break outerFor;
                    }
                }
            }

            // Check collision with other entities (bullets, monsters, npc, items etc.)
        }

        // This will render all entities on the map (npcs, bullets, player, items, chests, portals etc.)
        for (Entity entity : game.getEntityManager().getEntities()) {
            canvas.getGraphicsContext2D().drawImage(
                    entity.getImage(),
                    game.getCamera().processX(entity.getX()),
                    game.getCamera().processY(entity.getY()),
                    entity.getWidth(),
                    entity.getHeight()
            );

            if (Constants.SHOW_HIT_BOX) {
                canvas.getGraphicsContext2D().strokeRect(
                        game.getCamera().processX(entity.getX()),
                        game.getCamera().processY(entity.getY()),
                        entity.getWidth(),
                        entity.getHeight()
                );
            }
        }
    }
}