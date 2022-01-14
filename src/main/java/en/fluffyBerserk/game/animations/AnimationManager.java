package en.fluffyBerserk.game.animations;

import en.fluffyBerserk.game.logic.AnimatedEntity;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class AnimationManager {
    private static final int CHANGE_ANIMATION_NUMBER = 5;
    private int ticks = 0;
    private int animationNumber = 0;
    private final AnimationsFactory animationsFactory;

    public AnimationManager(ArrayList<Image> animations, AnimatedEntity entity) {
        animationsFactory = new AnimationsFactory();
    }

    private ArrayList<Image> getAnimationList(){
        return animationsFactory.getPortalAnimations();
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
