package en.fluffyBerserk.game.logic.maps;

import en.fluffyBerserk.Constants;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.gui.graphics.objects.ObjectsForMap6;


    public final class Map6 extends Map{
        Entity[] objects = ObjectsForMap6.loadObjects();

        @Override
        public String getName() {
            return "map6";
        }

        @Override
        public int getWidth() {
            return 30*Constants.TILE_SIZE;
        }

        @Override
        public int getHeight() {
            return 30*Constants.TILE_SIZE;
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

