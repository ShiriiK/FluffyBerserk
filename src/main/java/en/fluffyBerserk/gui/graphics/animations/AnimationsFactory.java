package en.fluffyBerserk.gui.graphics.animations;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.gui.graphics.sprites.SpriteImage;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class AnimationsFactory {
    public static ArrayList<Image> portal, bullets;

    /**
     * Creates animations for portal
     */
    public static ArrayList<Image> portalAnimations() {
        portal = new ArrayList<>(4);

        portal.add(0, new Image("objects/portal/pt1.png", Constants.TILE_SIZE,Constants.TILE_SIZE,false, false));
        portal.add(1, new Image("objects/portal/pt2.png", Constants.TILE_SIZE,Constants.TILE_SIZE,false, false));
        portal.add(2, new Image("objects/portal/pt3.png", Constants.TILE_SIZE,Constants.TILE_SIZE,false, false));
        portal.add(3, new Image("objects/portal/pt4.png", Constants.TILE_SIZE,Constants.TILE_SIZE,false, false));

        return portal;
    }

    public static ArrayList<Image> bulletAnimations() {
        LocateImage sprite = new LocateImage("bullets/flufball_basic_sprite.png");

        bullets.add(new SpriteImage(sprite, 0,0, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());
        bullets.add(new SpriteImage(sprite, Constants.TILE_SIZE,0, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());
        bullets.add(new SpriteImage(sprite, 0,Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());
        bullets.add(new SpriteImage(sprite, Constants.TILE_SIZE,Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE).getFrame());

        return null;
    }
}
