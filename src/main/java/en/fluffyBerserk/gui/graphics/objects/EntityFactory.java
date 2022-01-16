package en.fluffyBerserk.gui.graphics.objects;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.Entity;
import javafx.scene.image.Image;

public class EntityFactory {

    public static final Entity bed = new Entity(ObjectType.BED) {
        @Override
        public Image getImage() {
            return new Image("objects/bed.png");
        }

        @Override
        public int getHeight() {
            return (int) (Constants.TILE_SIZE * 1.5);
        }

        @Override
        public int getWidth() {
            return Constants.TILE_SIZE;
        }
    };

    public static final Entity carpet = new Entity(ObjectType.CARPET) {
        @Override
        public Image getImage() {
            return new Image("objects/carpet.png");
        }

        @Override
        public int getHeight() {
            return Constants.TILE_SIZE / 2;
        }

        @Override
        public int getWidth() {
            return Constants.TILE_SIZE;
        }
    };

    public static final Entity home = new Entity(ObjectType.HOME) {
        @Override
        public Image getImage() {
            return new Image("objects/house.png");
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
            return (int) (Constants.TILE_SIZE * 1.5);
        }

        @Override
        public int getHitBoxWidth() {
            return Constants.TILE_SIZE * 2;
        }

        @Override
        public float getHitBoxX() {
            return (float) (Constants.TILE_SIZE * 5.5);
        }

        @Override
        public float getHitBoxY() {
            return Constants.TILE_SIZE;
        }
    };


}
