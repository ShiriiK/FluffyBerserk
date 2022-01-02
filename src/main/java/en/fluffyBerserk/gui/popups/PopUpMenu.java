package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.gui.screens.SaveSlotsScreen;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.screens.LoginScreen;

/**
 * BasePopUp extension class that displays menu.
 */

public final class PopUpMenu extends BasePopUp {

    @Override
    protected String getPopUpTitle() {
        return "Menu";
    }

    @Override
    protected void initPopUpStage() {
        VBox buttons = new VBox();

        Button resumeButton = new Button("Resume");
        resumeButton.setOnAction(event -> Main.app.hidePopUp());

        Button saveButton = new Button("Save game");
        Button loadButton = new Button("Load game");

        loadButton.setOnAction(event -> Main.app.changeScreen(new SaveSlotsScreen()));

        Button helpButton = new Button("Help");
        helpButton.setOnAction(event -> Main.app.showPopUp(new PopUpHelp()));

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(event -> Main.app.changeScreen(new LoginScreen()));

        Button deleteSaveButton = new Button("Delete save");
        Button deleteAccountButton = new Button("Delete account");

        buttons.getChildren().addAll(resumeButton,saveButton,loadButton,helpButton,logoutButton,deleteSaveButton,deleteAccountButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        BorderPane root = new BorderPane();
        root.setCenter(buttons);

        popUpStage.setScene(new Scene(root, Color.TRANSPARENT));
    }

    @Override
    public void onShow() {
        System.out.println("Menu shown");
    }

    @Override
    public void onHide() {
        System.out.println("Menu hidden");
    }
}
