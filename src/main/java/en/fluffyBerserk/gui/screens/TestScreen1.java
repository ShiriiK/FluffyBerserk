package en.fluffyBerserk.gui.screens;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import en.fluffyBerserk.base.Main;
import en.fluffyBerserk.gui.popups.PopUpMenu;

public final class TestScreen1 extends BaseScreen {

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        Label label = new Label("This is test screen 1");

        Button screenButton = new Button("Test screen 2");
        screenButton.setOnAction(event -> Main.app.changeScreen(new TestScreen2()));

        Button popUpButton = new Button("Test pop-up 1");
        popUpButton.setOnAction(e -> Main.app.showPopUp(new PopUpMenu()));

        root.getChildren().addAll(label, screenButton, popUpButton);

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        System.out.println("Entered test screen 1 screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left test screen 1 screen");
    }
}
