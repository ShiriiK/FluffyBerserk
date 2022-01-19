package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.gamecontrolls.Game;

public class PlayerSpawnManager {
    private Game game;

    public PlayerSpawnManager(Game game) {
        this.game = game;
    }

    public void spawnOnMap(int mapId){
        double timesX = 0;
        double timesY = 0;

        /** Times X and Y is a tile grid position coordinates. It will put a player and hitbox on that X and Y */
        switch (mapId) {
            case 1:
                if (game.getCurrentMap().getName().equals("map2")) {
                    timesX = 5.5F;
                    timesY = 2.5F;
                } else {
                    timesX = 16F;
                    timesY = 7F;
                }
                break;
            case 2:
                timesX = 4.5F;
                timesY = 7F;
                break;
            case 3:
                timesX = 4F;
                timesY = 16F;
                break;
            case 4:
                timesX = 4F;
                timesY = 15F;
                break;
            case 5:
                timesX = 6F;
                timesY = 17F;
                break;
            case 6:
                timesX = 13F;
                timesY = 19F;
                break;
        }

        game.getPlayer().setX((float) (Constants.TILE_SIZE * timesX));
        game.getPlayer().setY((float) (Constants.TILE_SIZE * timesY));
        game.getPlayer().setHitBoxX(game.getPlayer().getX() + 20);
        game.getPlayer().setHitBoxY(game.getPlayer().getY() + 30);
    }
}
