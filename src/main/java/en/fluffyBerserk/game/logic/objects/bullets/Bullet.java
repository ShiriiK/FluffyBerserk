package en.fluffyBerserk.game.logic.objects.bullets;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.logic.Animated;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.MovableEntity;
import en.fluffyBerserk.gui.graphics.animations.AnimationManager;
import en.fluffyBerserk.gui.graphics.animations.AnimationsFactory;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Bullet extends MovableEntity implements Animated {

    protected final AnimationManager animationManager;
    protected final ArrayList<Image> animations;
    public static final float SPEED = 12F;
    public int bulletDmg = 0;
    public int lifeSpan= 2;                     //how many gameLoops will bullet go after dealing damage.

    public Bullet() {
        super(ObjectType.BULLET_PLAYER);
        animations = AnimationsFactory.bulletAnimations();
        animationManager = new AnimationManager(this);
        bulletDmg = Main.app.getGame().getPlayer().getDmg();
    }

    public int getDmg() {return bulletDmg;}

    public void setDmg(int dmg){this.bulletDmg = dmg;}

    public void reduceLifeSpan(){this.lifeSpan--;}

    @Override
    public int getHeight() {
        return Constants.BASE_TILE_SIZE;
    }

    @Override
    public int getWidth() {
        return Constants.BASE_TILE_SIZE;
    }

    @Override
    public Image getImage() {
        return animationManager.getImage();
    }

    @Override
    public ArrayList<Image> getAnimations() {
        return animations;
    }

    @Override
    public AnimationManager getAnimationManager() {
        return animationManager;
    }
}
