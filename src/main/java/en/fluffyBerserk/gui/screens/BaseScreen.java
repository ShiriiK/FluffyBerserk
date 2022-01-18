package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.gui.nodes.NodesFactory;
import javafx.scene.Scene;

public abstract class BaseScreen implements Screen {

    protected NodesFactory factory = new NodesFactory();

    public Scene getScene() {
        return buildScene();
    }

    public void onEnter() {
        //
    }

    public void onLeave() {
        //
    }

    protected abstract Scene buildScene();
}
