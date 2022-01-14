package en.fluffyBerserk.game.logic;

import en.fluffyBerserk.game.animations.AnimationManager;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.utils.LocateImage;

public abstract class AnimatedEntity extends Entity {

    protected final AnimationManager animationManager;

    public AnimatedEntity(LocateImage sprite) {
        animationManager = new AnimationManager(sprite, this);
    }

    public AnimationManager getAnimationManager() {
        return animationManager;
    }
}
