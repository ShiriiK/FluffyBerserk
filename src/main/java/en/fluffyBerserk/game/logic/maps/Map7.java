package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.graphics.objects.ObjectsOnMap2;
import en.fluffyBerserk.gui.graphics.objects.ObjectsOnMap7;


    public final class Map7 extends Map{
        Entity[] objects = ObjectsOnMap7.loadObjects();

        @Override
        public String getName() {
            return "map7";
        }

        @Override
        public int getWidth() {
            return Constants.WORLD_WIDTH;
        }

        @Override
        public int getHeight() {
            return Constants.WORLD_HEIGHT;
        }

        @Override
        public Entity[] getObjects() {
            return objects;
        }
    }

