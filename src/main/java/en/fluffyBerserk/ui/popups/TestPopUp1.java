package main.java.en.fluffyBerserk.ui.popups;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.en.fluffyBerserk.Main;
import main.java.en.fluffyBerserk.ui.screens.TestScreen2;
import main.java.en.fluffyBerserk.ui.utils.PopUpStageBuilder;

public final class TestPopUp1 implements PopUp {

    private final Stage popUpStage;

    public TestPopUp1() {
        popUpStage = PopUpStageBuilder.buildDefaultStage();
        init();
    }

    private void init() {
        VBox pauseRoot = new VBox(5);

        pauseRoot.getChildren().add(new Label("This is test pop-up 1"));
        pauseRoot.setStyle("-fx-background-color: rgba(150, 150, 150, 0.8);");
        pauseRoot.setAlignment(Pos.CENTER);
        pauseRoot.setPadding(new Insets(20));

        Button resume = new Button("Resume");
        pauseRoot.getChildren().add(resume);

        Button toDefaultScreen = new Button("To test screen 2");
        pauseRoot.getChildren().add(toDefaultScreen);

        resume.setOnAction(event -> Main.app.hidePopUp());

        toDefaultScreen.setOnAction(event -> Main.app.changeScreen(new TestScreen2()));

        popUpStage.setTitle("Test pop-up 1");
        popUpStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));
    }

    @Override
    public Stage getPopUpStage() {
        return popUpStage;
    }

    @Override
    public void onShow() {
        System.out.println("Test pop up 1 shown");
    }

    @Override
    public void onHide() {
        System.out.println("Test pop up 1 hidden");
    }
}
