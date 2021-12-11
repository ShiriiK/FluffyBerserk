package main.java.en.fluffyBerserk.ui.popups;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.java.en.fluffyBerserk.Main;
import main.java.en.fluffyBerserk.ui.screens.TestScreen2;

public final class TestPopUp1 extends BasePopUp {

    @Override
    protected String getPopUpTitle() {
        return "Test pop-up 1";
    }

    @Override
    protected void initPopUpStage() {
        VBox pauseRoot = new VBox(10);

        pauseRoot.getChildren().add(new Label("This is test pop-up 1"));
        pauseRoot.setStyle("-fx-background-color: rgba(150, 150, 150, 0.8);");
        pauseRoot.setAlignment(Pos.CENTER);
        pauseRoot.setPadding(new Insets(20));

        Button resume = new Button("Resume");
        pauseRoot.getChildren().add(resume);

        Button toScreen2 = new Button("To test screen 2");
        pauseRoot.getChildren().add(toScreen2);

        resume.setOnAction(event -> Main.app.hidePopUp());

        toScreen2.setOnAction(event -> Main.app.changeScreen(new TestScreen2()));

        popUpStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));
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
