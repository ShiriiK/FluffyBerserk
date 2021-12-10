package en.fluffyBerserk.ui.scenes;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import main.java.en.fluffyBerserk.ui.Scene;

public class HomeScreen implements Scene {
    private BorderPane borderPane;

    public HomeScreen(){
        borderPane = new BorderPane();
        init();
    }

    private void init() {
    }

    @Override
    public Node getNode() {
        return borderPane;
    }
}
