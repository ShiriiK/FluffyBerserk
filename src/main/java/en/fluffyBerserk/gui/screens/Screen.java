package en.fluffyBerserk.gui.screens;

import javafx.scene.Scene;

public interface Screen {

    public Scene getScene();

    public void onEnter();

    public void onLeave();
}
