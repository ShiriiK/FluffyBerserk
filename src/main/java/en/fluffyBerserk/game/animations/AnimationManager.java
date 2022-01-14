package en.fluffyBerserk.game.animations;

import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.utils.LocateImage;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class AnimationManager {
    private static final int CHANGE_ANIMATION_NUMBER = 5;
    private int ticks = 0;
    private int animationNumber = 0;
    private final PortalAnimations portalAnimations;
    private final Entity entity;


    public AnimationManager(LocateImage sprite, Entity entity) {
        this.entity = entity;
        portalAnimations = new PortalAnimations(sprite);
    }

    private ArrayList<Image> getAnimationList(){
        return portalAnimations.getPortalAnimations();
    }

    public Image getImage(){
        return getAnimationList().get(animationNumber);
    }

    public void increaseTick() {
        ticks++;

        if (ticks % CHANGE_ANIMATION_NUMBER == 0) {
            ticks = 0;
            animationNumber = (animationNumber + 1) > 3 ? 0 : animationNumber + 1;
        }
    }
}
