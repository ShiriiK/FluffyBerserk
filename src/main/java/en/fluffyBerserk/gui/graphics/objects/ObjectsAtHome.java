package en.fluffyBerserk.gui.graphics.objects;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.Entity;
import javafx.scene.image.Image;

public class ObjectsAtHome {

    public static Entity[] loadObjects() {
        Entity object[] = new Entity[3];

        prepareCarpet(object);
        prepareBed(object);

        return object;
    }

    private static void prepareBed(Entity[] object) {
        object[1] = new Entity(ObjectType.BED) {
            @Override
            public Image getImage() {
                return new Image("objects/bed.png");
            }

            @Override
            public int getHeight() {
                return (int) (Constants.TILE_SIZE*1.5);
            }

            @Override
            public int getWidth() {
                return Constants.TILE_SIZE;
            }
            @Override
            public int getHitBoxHeight() {
                return (int) (Constants.TILE_SIZE*1.5);
            }

            @Override
            public int getHitBoxWidth() {
                return Constants.TILE_SIZE;
            }
        };

        object[1].setX((float) (8 * Constants.TILE_SIZE));
        object[1].setY((float) (2 * Constants.TILE_SIZE));
    }

    private static void prepareCarpet(Entity[] object) {
        object[0] = new Entity(ObjectType.CARPET) {
            @Override
            public Image getImage() {
                return new Image("objects/carpet.png");
            }

            @Override
            public int getHeight() {
                return Constants.TILE_SIZE/2;
            }

            @Override
            public int getWidth() {
                return Constants.TILE_SIZE;
            }

        };

        object[0].setX((float) (4.5 * Constants.TILE_SIZE));
        object[0].setY((float) (8.5 * Constants.TILE_SIZE));
    }

}
