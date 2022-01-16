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

    public static final Entity closet = new Entity(ObjectType.CLOSET) {
        @Override
        public Image getImage() {
            return new Image("objects/closet1.png");
        }

        @Override
        public int getHeight() {
            return (int) (Constants.TILE_SIZE * 1.5);
        }

        @Override
        public int getWidth() {
            return (int) (Constants.TILE_SIZE * 1.25);
        }
    };

    public static final Entity plant = new Entity(ObjectType.TILE) {
        @Override
        public Image getImage() {
            return new Image("objects/plant2.png");
        }

        @Override
        public int getHeight() {
            return Constants.TILE_SIZE;
        }

        @Override
        public int getWidth() {
            return (int) (Constants.TILE_SIZE * 0.75);
        }
    };

    public static final Entity plant2 = new Entity(ObjectType.TILE) {
        @Override
        public Image getImage() {
            return new Image("objects/plant3.png");
        }

        @Override
        public int getHeight() {
            return Constants.TILE_SIZE;
        }

        @Override
        public int getWidth() {
            return (int) (Constants.TILE_SIZE * 0.5);
        }
    };

    public static final Entity library = new Entity(ObjectType.TILE) {
        @Override
        public Image getImage() {
            return new Image("objects/library.png");
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
    public static final Entity potions = new Entity(ObjectType.TILE) {
        @Override
        public Image getImage() {
            return new Image("objects/potions.png");
        }

        @Override
        public int getHeight() {
            return Constants.TILE_SIZE;
        }

        @Override
        public int getWidth() {
            return Constants.TILE_SIZE;
        }
    };
    public static final Entity herbs = new Entity(ObjectType.TILE) {
        @Override
        public Image getImage() {
            return new Image("objects/herbs.png");
        }

        @Override
        public int getHeight() {
            return Constants.TILE_SIZE;
        }

        @Override
        public int getWidth() {
            return Constants.TILE_SIZE;
        }
    };

    public static final Entity armchair = new Entity(ObjectType.TILE) {
        @Override
        public Image getImage() {
            return new Image("objects/armchair.png");
        }

        @Override
        public int getHeight() {
            return (int) (Constants.TILE_SIZE * 1.5);
        }

        @Override
        public int getWidth() {
            return (int) (Constants.TILE_SIZE * 0.75);
        }
    };

    public static final Entity fireplace = new Entity(ObjectType.TILE) {
        @Override
        public Image getImage() {
            return new Image("objects/fireplace.png");
        }

        @Override
        public int getHeight() {
            return Constants.TILE_SIZE * 2;
        }

        @Override
        public int getWidth() {
            return (int) (Constants.TILE_SIZE * 1.25);
        }
    };

    public static final Entity cabinet = new Entity(ObjectType.TILE) {
        @Override
        public Image getImage() {
            return new Image("objects/cabinet.png");
        }

        @Override
        public int getHeight() {
            return (int) (Constants.TILE_SIZE);
        }

        @Override
        public int getWidth() {
            return Constants.TILE_SIZE;
        }
    };

    public static final Entity table = new Entity(ObjectType.TILE) {
        @Override
        public Image getImage() {
            return new Image("objects/table.png");
        }

        @Override
        public int getHeight() {
            return Constants.TILE_SIZE;
        }

        @Override
        public int getWidth() {
            return Constants.TILE_SIZE * 2;
        }
    };

    public static final Entity boxes = new Entity(ObjectType.TILE) {
        @Override
        public Image getImage() {
            return new Image("objects/boxes.png");
        }

        @Override
        public int getHeight() {
            return Constants.TILE_SIZE;
        }

        @Override
        public int getWidth() {
            return Constants.TILE_SIZE;
        }
    };

    public static final Entity chair = new Entity(ObjectType.TILE) {
        @Override
        public Image getImage() {
            return new Image("objects/chair.png");
        }

        @Override
        public int getHeight() {
            return Constants.TILE_SIZE / 2;
        }

        @Override
        public int getWidth() {
            return Constants.TILE_SIZE / 2;
        }
    };
}
