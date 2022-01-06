package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.screens.EditScreen;
import en.fluffyBerserk.gui.screens.LoginScreen;
import en.fluffyBerserk.gui.screens.SaveSlotsScreen;
import en.fluffyBerserk.gui.utils.AttachCSS;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public final class PopUpMenu extends PopUp {

    @Override
    protected void initPopUpStage() {
        VBox buttons = new VBox();

        // Resume button
        Button resumeButton = new Button("Resume");
        resumeButton.setOnAction(event -> Main.app.hidePopUp());

        // Save button
        Button saveButton = new Button("Save game");

        // Load button
        Button loadButton = new Button("Load game");
        loadButton.setOnAction(event -> {
            Main.app.changeScreen(new SaveSlotsScreen());
        });

        // Edit button
        Button editButton = new Button("Edit character");
        editButton.setOnAction(event -> {
            Main.app.changeScreen(new EditScreen());
        });

        // Help button
        Button helpButton = new Button("Help");

        PopUpHelp popUpHelp = new PopUpHelp();

        helpButton.setOnAction(event -> {
            Main.app.showPopUp(popUpHelp);
        });

        // Logout button
        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(event -> Main.app.changeScreen(new LoginScreen()));

        // Delete save button
        Button deleteSaveButton = new Button("Delete save");

        // Delete account button
        Button deleteAccountButton = new Button("Delete account");

        buttons.getChildren().addAll(resumeButton, saveButton, loadButton, editButton, helpButton, logoutButton, deleteSaveButton, deleteAccountButton);
        buttons.getStyleClass().add("vbox");


        Scene scene = new Scene(buttons);
        scene.setFill(Color.TRANSPARENT);
        AttachCSS.attachCSS(scene);

        popUpStage.setScene(scene);
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
