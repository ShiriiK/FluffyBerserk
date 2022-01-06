package en.fluffyBerserk;

import en.fluffyBerserk.gui.screens.HomeScreen;
import javafx.stage.Stage;
import en.fluffyBerserk.base.Application;

public final class Main extends javafx.application.Application {

    // Static reference to application instance
    // so all classes don't have to pass ref
    // over and over
    public static Application app;

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        (app = new Application(primaryStage)).start(new HomeScreen());
    }
}
