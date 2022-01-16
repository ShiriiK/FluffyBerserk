package en.fluffyBerserk.game.logic.objects;

import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.gui.graphics.animations.AnimationManager;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class AnimatedEntity extends Entity {

    protected final AnimationManager animationManager;
    protected final ArrayList<Image> animations;

    public AnimatedEntity(ObjectType type) {
        super(type);
        animations = setAnimations();
        animationManager = new AnimationManager(this);
    }

    public ArrayList<Image> getAnimations() {
        return animations;
    }

    public AnimationManager getAnimationManager() {
        return animationManager;
    }

    protected abstract ArrayList<Image> setAnimations();

}
