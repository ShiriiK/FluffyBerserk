package en.fluffyBerserk.gui.tile;

import javafx.scene.image.Image;

public class Tile {
    public Image image;
    public boolean collision = false;

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean isCollision() {
        return collision;
    }

    // TODO will add collisions here or something like that
}
