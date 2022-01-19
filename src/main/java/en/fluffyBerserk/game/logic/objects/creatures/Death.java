package en.fluffyBerserk.game.logic.objects.creatures;

import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.Entity;
import javafx.scene.image.Image;

public class Death extends Entity {

    public Death() {
        super(ObjectType.TILE);
    }

    @Override
    public Image getImage() {
        return new Image("npcs/death.png");
    }
};


