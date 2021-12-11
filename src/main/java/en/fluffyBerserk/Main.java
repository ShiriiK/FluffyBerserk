package main.java.en.fluffyBerserk;

import javafx.stage.Stage;
import main.java.en.fluffyBerserk.base.Application;


public class Main extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new Application(primaryStage).start();
    }
}
