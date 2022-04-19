package en.fluffyBerserk.game.logic.objects.creatures.npc.npcs;

import en.fluffyBerserk.game.logic.ObjectType;
import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.MovableEntity;
import javafx.scene.image.Image;

public class Death extends MovableEntity {

    public int lifeSpan = 10;

    public Death() {
        super(ObjectType.TILE);
    }

    public void reduceLifeSpan() {
        this.lifeSpan--;
    }

    @Override
    public Image getImage() {
        return new Image("npcs/death.png");
    }
};


