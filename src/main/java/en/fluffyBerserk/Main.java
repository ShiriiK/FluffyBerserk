package main.java.en.fluffyBerserk;

import javafx.stage.Stage;
import main.java.en.fluffyBerserk.base.Application;

public class Main extends javafx.application.Application {

    // Static reference to application instance
    // so all classes don't have to pass ref
    // over and over
    public static Application app;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        (app = new Application(primaryStage)).start();
    }
}
