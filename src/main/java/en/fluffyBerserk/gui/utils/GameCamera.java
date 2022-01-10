package en.fluffyBerserk.gui.utils;

import en.fluffyBerserk.invariables.Constant;
import en.fluffyBerserk.game.logic.objects.Entity;

public class GameCamera {
    private float xOffset, yOffset;

    public GameCamera(float xOffset, float yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void blankSpace(){
        if(xOffset < 0){
            xOffset = 0;
        }
        if(yOffset < 0){
            yOffset = 0;
        }
    }

    public void centrOnEntity(Entity entity) {
        setxOffset(entity.getWorldX() - Constant.SCREEN_WIDTH / 2 + Constant.TILE_SIZE / 2);
        setyOffset(entity.getWorldY() - Constant.SCREEN_HEIGHT / 2 + Constant.TILE_SIZE / 2);
        blankSpace();
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
