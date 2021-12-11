package main.java.en.fluffyBerserk.ui.screens;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.en.fluffyBerserk.base.Application;

public class AnotherScreen implements Screen {

    private Application application;

    private Scene scene;

    public AnotherScreen(Application application) {
        this.application = application;
        init();
    }

    private void init() {
        VBox root = new VBox();

        Button button = new Button("Switch to default scene");
        button.setOnAction(event -> {
            application.changeScreen(new DefaultScreen(application));
        });

        Button modalButton = new Button("Show pop up");
        modalButton.setOnAction(e -> {
            root.setEffect(new GaussianBlur());
            root.setEffect(new GaussianBlur());

            VBox pauseRoot = new VBox(5);
            pauseRoot.getChildren().add(new Label("Paused"));
            pauseRoot.setStyle("-fx-background-color: rgba(150, 150, 150, 0.8);");
            pauseRoot.setAlignment(Pos.CENTER);
            pauseRoot.setPadding(new Insets(20));

            Button resume = new Button("Resume");
            pauseRoot.getChildren().add(resume);

            Button toDefaultScreen = new Button("Default screen");
            pauseRoot.getChildren().add(toDefaultScreen);

            Stage popupStage = new Stage(StageStyle.TRANSPARENT);
            popupStage.initOwner(application.getPrimaryStage());
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(pauseRoot, Color.BLACK));

            resume.setOnAction(event -> {
                root.setEffect(null);
                popupStage.hide();
            });

            toDefaultScreen.setOnAction(event -> {
                application.changeScreen(new DefaultScreen(application));
            });

            popupStage.show();
        });

        root.getChildren().addAll(button, modalButton);

        scene = new Scene(root);
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void onEnter() {
        System.out.println("Entered another screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left another screen");
    }
}
