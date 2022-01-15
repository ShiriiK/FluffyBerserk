package en.fluffyBerserk.game.logic.objects.bullets;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.MovableEntity;
import javafx.scene.image.Image;

public class Bullet extends MovableEntity {

    public Bullet(ObjectType type) {
        super(type);
    }

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
        return BulletImages.getByIndex(BulletImages.BULLET_BASIC);
    }
}
