package en.fluffyBerserk.gui.screens;
import en.fluffyBerserk.gui.utils.PopUpCenter;
import javafx.scene.Scene;

/**
 * This class serves as an abstract base class for all screens
 */
public abstract class BaseScreen implements Screen {

    protected final PopUpCenter popUpCenter;

    public BaseScreen(){
        popUpCenter = new PopUpCenter();
    }

    @Override
    public Scene getScene() {
        return buildScene();
    }

    @Override
    public void onEnter() {
        //
    }

    @Override
    public void onLeave() {
        //
    }

    // Abstract methods used in classes extending this class
    protected abstract Scene buildScene();
}
