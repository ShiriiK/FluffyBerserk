package en.fluffyBerserk.gui.graphics.animations;

import en.fluffyBerserk.game.logic.objects.AnimatedEntity;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.MovableEntity;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class AnimationManager {
    private static final int CHANGE_ANIMATION_NUMBER = 5;
    private int ticks = 0;
    private int animationNumber = 0;
    private final AnimatedEntity entity;
    private final ArrayList<Image> animations;

    public AnimationManager(AnimatedEntity entity) {
        this.entity = entity;
        this.animations = entity.getAnimations();
    }

    private ArrayList<Image> getAnimationList(){
        return animations;
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
