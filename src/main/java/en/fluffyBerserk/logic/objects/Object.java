package en.fluffyBerserk.logic.objects;

import javafx.scene.shape.Rectangle;

/**
 * Interface for static objects
 */


public interface Object {

    void setWorldX(float worldX);

    void setWorldY(float worldY);

    float getWorldX();

    float getWorldY();

    String getImagePath();

}
