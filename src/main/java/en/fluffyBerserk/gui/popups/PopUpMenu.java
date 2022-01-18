package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.screens.HomeScreen;
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

        // Resume button ✔
        Button resumeButton = new Button("Resume");
        resumeButton.setOnAction(event ->{
            Main.app.hidePopUp();
            Main.app.getGame().getGameLoop().start();
        });

        // Save button
        Button saveButton = new Button("Save game"); //TODO

        // Load button ✔
        Button loadButton = new Button("Load game");
        loadButton.setOnAction(event -> {
            Main.app.changeScreen(new SaveSlotsScreen());
        });

        // Help button ✔
        Button helpButton = new Button("Help");

        PopUpHelp popUpHelp = new PopUpHelp();
        helpButton.setOnAction(event -> {
            Main.app.showPopUp(popUpHelp);
        });

        // Logout button ✔
        Button logoutButton = factory.getLogOutButton();

        // Delete save button ✔
        Button deleteCharacterButton = factory.getDeleteCharacterButton(Main.app.getGame().getPlayer().getCharacter());

        // Delete account button ✔
        Button deleteAccountButton = factory.getDeleteAccountButton(Main.app.getUser());

        if (!Main.app.isUserLoggedIn()){
            saveButton.setDisable(true);
            loadButton.setDisable(true);
            deleteCharacterButton.setDisable(true);
            deleteAccountButton.setDisable(true);
            logoutButton.setText("Leave game");
        }

        buttons.getChildren().addAll(resumeButton, saveButton, loadButton, helpButton, logoutButton, deleteCharacterButton, deleteAccountButton);
        buttons.getStyleClass().add("pop-up-menu");


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
