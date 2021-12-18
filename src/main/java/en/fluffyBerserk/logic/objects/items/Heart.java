package en.fluffyBerserk.logic.objects.items;

public class Heart extends PickableItem {

    @Override
    public String getName() {
        return "Heart";
    }

    @Override
    public String getImagePath() {
        return ""; // TODO
    }

    @Override
    public void pick() {
        // TODO add health to user, don't add it to inventory!!
    }
}
