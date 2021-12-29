package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.screens.EditScreen;
import en.fluffyBerserk.gui.screens.LoginScreen;
import en.fluffyBerserk.gui.screens.SaveSlotsScreen;
import en.fluffyBerserk.logic.Game;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

public class PopUpFactory {

    public static Popup getPopUpMenu(){
        VBox vBox = new VBox();
        Popup popup = new Popup();
        popup.setAutoHide(true);

        Button resumeButton = new Button("Resume");
        resumeButton.setOnAction(event -> Main.app.hidePopUp());

        Button saveButton = new Button("Save game");
        Button loadButton = new Button("Load game");

        loadButton.setOnAction(event -> Main.app.changeScreen(new SaveSlotsScreen()));

        Button editButton = new Button("Edit character");
        editButton.setOnAction(event -> Main.app.changeScreen(new EditScreen(new Game())));

        Button helpButton = new Button("Help");

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(event ->{
            Main.app.changeScreen(new LoginScreen());
            popup.hide();
        });

        Button deleteSaveButton = new Button("Delete save");
        Button deleteAccountButton = new Button("Delete account");

        vBox.getChildren().addAll(resumeButton,saveButton,loadButton,editButton,helpButton,logoutButton,deleteSaveButton,deleteAccountButton);

        vBox.getStyleClass().add("vbox");
        popup.getContent().add(vBox);
        return popup;
    };

}
