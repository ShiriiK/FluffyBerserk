package en.fluffyBerserk.game.animations;

import en.fluffyBerserk.game.Constants;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class AnimationsFactory {
    public static ArrayList<Image> portal;

    /**
     * Creates animations for portal
     */
    public static ArrayList<Image> portalAnimations() {
        portal = new ArrayList<>(3);

        portal.add(0, new Image("objects/portal/pt1.png", Constants.TILE_SIZE,Constants.TILE_SIZE,false, false));
        portal.add(1, new Image("objects/portal/pt2.png", Constants.TILE_SIZE,Constants.TILE_SIZE,false, false));
        portal.add(2, new Image("objects/portal/pt3.png", Constants.TILE_SIZE,Constants.TILE_SIZE,false, false));
        portal.add(3, new Image("objects/portal/pt4.png", Constants.TILE_SIZE,Constants.TILE_SIZE,false, false));

        return portal;
    }

    public ArrayList<Image> getPortalAnimations() {
        return portal;
    }
}
