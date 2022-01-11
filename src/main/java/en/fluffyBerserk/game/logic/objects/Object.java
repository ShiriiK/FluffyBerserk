package en.fluffyBerserk.game.logic.objects;

import javafx.scene.image.Image;

public interface Object {

    void setX(float x);

    void setY(float y);

    float getX();

    float getY();

    int getHeight();

    int getWidth();

    Image getImage();
}
