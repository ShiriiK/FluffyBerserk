package en.fluffyBerserk.game.logic.objects;

import en.fluffyBerserk.gui.graphics.animations.AnimationManager;
import en.fluffyBerserk.game.logic.ObjectType;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class AnimatedEntity extends Entity {

    protected final AnimationManager animationManager;
    protected final ArrayList<Image> animations;

    public AnimatedEntity(ObjectType type) {
        super(type);
        animations = setAnimations();
        animationManager = new AnimationManager(animations, this);
    }

    public AnimationManager getAnimationManager() {
        return animationManager;
    }
    protected abstract ArrayList<Image> setAnimations();

}
