package en.fluffyBerserk.objects.items;

import java.util.ArrayList;

public class Chest extends Item {

    private ArrayList<Item> items;

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> open() {
        return items;
    }

    @Override
    public String getImagePath() {
        return ""; // TODO
    }

    @Override
    public String getName() {
        return "Chest";
    }
}
