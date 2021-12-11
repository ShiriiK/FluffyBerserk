package main.java.en.fluffyBerserk.ui.popups;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.java.en.fluffyBerserk.Main;
import main.java.en.fluffyBerserk.ui.screens.TestScreen1;

public final class TestPopUp2 extends BasePopUp {

    @Override
    protected String getPopUpTitle() {
        return "Test pop-up 2";
    }

    @Override
    protected void initPopUpStage() {
        VBox pauseRoot = new VBox(10);

        pauseRoot.getChildren().add(new Label("This is test pop-up 2"));
        pauseRoot.setAlignment(Pos.CENTER);
        pauseRoot.setPadding(new Insets(20));

        Button resume = new Button("Resume");
        pauseRoot.getChildren().add(resume);

        Button toScreen1 = new Button("To test screen 1");
        pauseRoot.getChildren().add(toScreen1);

        resume.setOnAction(event -> Main.app.hidePopUp());

        toScreen1.setOnAction(event -> Main.app.changeScreen(new TestScreen1()));

        popUpStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));
    }

    @Override
    public void onShow() {
        System.out.println("Test pop up 2 shown");
    }

    @Override
    public void onHide() {
        System.out.println("Test pop up 2 hidden");
    }
}
