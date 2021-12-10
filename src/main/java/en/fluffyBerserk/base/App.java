package main.java.en.fluffyBerserk.base;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import en.fluffyBerserk.ui.scenes.HomeScreen;

public class App {
    private Stage stage;
    public Scene actualScene;

    public App(Stage stage){
        this.stage = stage;
        this.init();
    }

    public void init(){
        Pane pane = new Pane();
        HomeScreen homeScreen = new HomeScreen();
        pane.getChildren().add(homeScreen.getNode());
        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(true);
        stage.setTitle("Fluffy Berserk");
        stage.show();
    }

    private void update(){
        stage.setScene(actualScene);
    }
}
