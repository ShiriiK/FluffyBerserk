package en.fluffyBerserk.gui.nodes;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.form.CharacterForm;
import en.fluffyBerserk.gui.screens.HomeScreen;
import en.fluffyBerserk.gui.screens.SaveSlotsScreen;
import en.fluffyBerserk.gui.utils.Handy;
import en.fluffyBerserk.persistence.DeleteTask;
import en.fluffyBerserk.persistence.UpdateTask;
import en.fluffyBerserk.persistence.models.Character;
import en.fluffyBerserk.persistence.models.User;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class NodesFactory {

    private Button deleteAccountButton, logOutButton, deleteCharacterButton, saveCharacterButton;

    private void setDeleteAccountButton(User user) {
        deleteAccountButton = new Button("Delete Account");
        deleteAccountButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm deleting your account");
            alert.setHeaderText("Are you sure you want to delete your account?");
            alert.setContentText("If the account will be deleted, you will lose your progress in the game.");

            ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Delete");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Main.app.logout();
                if (new DeleteTask<User>().delete(user)) {
                    if(Main.app.getGame() != null){
                        Main.app.getGame().getGameLoop().stop();
                        Main.app.setGame(null);
                    }
                    Main.app.changeScreen(new HomeScreen());
                }
            }
        });
    }

    public Button getDeleteAccountButton(User user) {
        setDeleteAccountButton(user);
        return deleteAccountButton;
    }

    private void setLogOutButton() {
        logOutButton = new Button("Log out");
        logOutButton.setOnAction(event -> {
            if(Main.app.getGame() != null){
                Main.app.getGame().getGameLoop().stop();
                Main.app.setGame(null);
            }
            Main.app.logout();
            Main.app.changeScreen(new HomeScreen());
        });
    }

    public Button getLogOutButton() {
        setLogOutButton();
        return logOutButton;
    }

    private void setDeleteCharacterButton(Character character) {
        deleteCharacterButton = new Button("Delete character");
        deleteCharacterButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm deleting your character");
            alert.setHeaderText("Are you sure you want to delete your character?");
            alert.setContentText("If the character will be deleted, you will lose your progress in the game.");

            ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Delete");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                if (new DeleteTask<Character>().delete(character)) {
                    if(Main.app.getGame() != null){
                        Main.app.getGame().getGameLoop().stop();
                        Main.app.setGame(null);
                    }
                    Main.app.changeScreen(new SaveSlotsScreen());
                }

            }
        });
    }

    public Button getDeleteCharacterButton(Character character) {
        setDeleteCharacterButton(character);
        return deleteCharacterButton;
    }

    private void setSaveCharacterButton(Character character, CharacterForm form) {
        saveCharacterButton = new Button("Save character");
        saveCharacterButton.setOnAction(event -> {
            form.clearErrors();

            if (!form.validate()) {
                Main.app.redrawScene();
                return;
            }

            character.setName(form.getName());
            character.setArmor(form.getArmor());
            character.setIntellect(form.getIntellect());
            character.setStamina(form.getStamina());
            character.setStrength(form.getStrength());
            character.setSpriteIndex(form.getSprite().getIndex());

            if(Main.app.getGame() != null){
                Main.app.getGame().getPlayer().getCharacter().setSpriteIndex(form.getSprite().getIndex());
            }

            new UpdateTask<Character>().update(character);


        });
    }

    public Button getSaveCharacterButton(Character character, CharacterForm form) {
        setSaveCharacterButton(character, form);
        return saveCharacterButton;
    }
}
