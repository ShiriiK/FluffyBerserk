package en.fluffyBerserk.logic.objects;

import javafx.scene.shape.Rectangle;

/**
 * Abstract class for all static objects
 */

public abstract class Entity implements Object, HasName {

    protected String name;

    protected float worldX;

    protected float worldY;

    protected Rectangle solidArea;

    public Entity(){
        name = getName();
    }

    @Override
    public void setWorldX(float worldX) {
        this.worldX = worldX;
    }

    @Override
    public void setWorldY(float worldY) {
        this.worldY = worldY;
    }

    @Override
    public float getWorldX() {
        return worldX;
    }

    @Override
    public float getWorldY() {
        return worldY;
    }

    /**@Override
    public Rectangle getSolidArea(){
        return solidArea;
    }*/
}
