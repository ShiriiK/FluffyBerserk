package en.fluffyBerserk.game.animations;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class PortalAnimations {
    public ArrayList<Image> portal;
    public LocateImage usedSprite;

    /**
     * Creates animations for portal based on chosen sprite
     *
     * @param sprite image in resources folder that contains multiple images of given entity
     */
    public PortalAnimations(LocateImage sprite) {
        usedSprite = new LocateImage(sprite.getPath(), sprite.getIndex());
        int w = Constants.BASE_TILE_SIZE;
        int h = Constants.BASE_TILE_SIZE;
        portal = new ArrayList<>(3);

        portal.add(0, new SpriteImage(SpritesFactory.getObjectSpriteByNumber(0),0 , 0, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());
        portal.add(1, new SpriteImage(SpritesFactory.getObjectSpriteByNumber(0),Constants.TILE_SIZE , 0, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());
        portal.add(2, new SpriteImage(SpritesFactory.getObjectSpriteByNumber(0), 2*Constants.TILE_SIZE, 0, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());
        portal.add(3, new SpriteImage(SpritesFactory.getObjectSpriteByNumber(0), 3*Constants.TILE_SIZE, 0, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());

    }

    public ArrayList<Image> getPortalAnimations() {
        return portal;
    }

}
