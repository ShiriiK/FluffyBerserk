package en.fluffyBerserk.game.logic.objects;

import en.fluffyBerserk.game.animations.AnimationManager;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.Entity;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class AnimatedEntity extends Entity {

    protected final AnimationManager animationManager;
    protected final ArrayList<Image> animations;
    protected final ObjectType type;

    public AnimatedEntity(ObjectType type) {
        this.type = type;
        animations = setAnimations();
        animationManager = new AnimationManager(animations, this);
    }

    public AnimationManager getAnimationManager() {
        return animationManager;
    }
    protected abstract ArrayList<Image> setAnimations();

    public ObjectType getType() {
        return type;
    }
}
