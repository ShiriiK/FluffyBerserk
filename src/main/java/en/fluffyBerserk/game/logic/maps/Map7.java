package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.graphics.objects.ObjectsForMap7;


    public final class Map7 extends Map{
        Entity[] objects = ObjectsForMap7.loadObjects();

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
        public boolean isLocked() {
            return true;
        }

        @Override
        public Entity[] getObjects() {
            return objects;
        }
    }

