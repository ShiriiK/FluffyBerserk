package en.fluffyBerserk.game.graphics.objects;

import en.fluffyBerserk.game.Constants;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.AnimatedEntity;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.portals.HomePortal;
import javafx.scene.image.Image;

public class ObjectsInSafeZone {

    public static Entity[] loadObjects() {
        Entity objects[] = new Entity[2];

        objects[0] = new HomePortal() {
            @Override
            public int getHeight() {
                return Constants.TILE_SIZE * 2;
            }

            @Override
            public int getWidth() {
                return Constants.TILE_SIZE;
            }

            @Override
            public int getHitBoxHeight() {
                return getHeight();
            }

            @Override
            public int getHitBoxWidth() {
                return getWidth();
            }
        };
        objects[0].setX(17 * Constants.TILE_SIZE);
        objects[0].setY((float) (6.5 * Constants.TILE_SIZE));

        objects[1] = new Entity(ObjectType.HOME) {
            @Override
            public Image getImage() {
                return new Image("objects/house.png", Constants.TILE_SIZE*2, Constants.TILE_SIZE*2, false, false);
            }

            @Override
            public int getHeight() {
                return Constants.TILE_SIZE * 3;
            }

            @Override
            public int getWidth() {
                return Constants.TILE_SIZE * 3;
            }

            @Override
            public int getHitBoxHeight() {
                return (int) (Constants.TILE_SIZE*1.5);
            }

            @Override
            public int getHitBoxWidth() {
                return Constants.TILE_SIZE*2;
            }

            @Override
            public float getHitBoxX(){
                return (float) (Constants.TILE_SIZE * 5.5);
            }

            @Override
            public float getHitBoxY(){
                return Constants.TILE_SIZE;
            }


        };
        objects[1].setX(Constants.TILE_SIZE*5);
        objects[1].setY(0);

        return objects;
    }


}
