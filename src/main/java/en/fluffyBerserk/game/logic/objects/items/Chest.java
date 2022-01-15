package en.fluffyBerserk.game.logic.objects.items;

import en.fluffyBerserk.game.logic.ObjectType;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Chest extends Item {

    private ArrayList<Item> items;

    public Chest(ObjectType type) {
        super(type);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> open() {
        return items;
    }

    @Override
    public String getName() {
        return "Chest";
    }

    @Override
    public Image getImage() {
        return null; //TODO
    }
}
