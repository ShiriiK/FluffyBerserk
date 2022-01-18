package en.fluffyBerserk.game.logic;

import en.fluffyBerserk.gui.graphics.animations.AnimationManager;
import javafx.scene.image.Image;

import java.util.ArrayList;

public interface Animated {
    ArrayList<Image> getAnimations();
    AnimationManager getAnimationManager();


}
