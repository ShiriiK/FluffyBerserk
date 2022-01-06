package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.persistence.DeleteTask;
import en.fluffyBerserk.persistence.SelectTask;
import en.fluffyBerserk.persistence.models.Character;
import en.fluffyBerserk.persistence.models.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.Nullable;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public final class SaveSlotsScreen extends BaseScreen {

    @Override
    protected Scene buildScene() {
        final User user = Main.app.getUser();
        assert user != null;

        final VBox root = new VBox();
        root.setPadding(new Insets(15, 15, 15, 15));
        root.setSpacing(10.0);
        root.setAlignment(Pos.CENTER);

        final List<Character> characters = new SelectTask<Character>().multiNamedQuery(manager -> {
            TypedQuery<Character> query = manager.createNamedQuery("Character.byUserId", Character.class);
            query.setParameter(1, user.getId());
            return query;
        });

        // Add empty slots
        if (characters.size() != 3) {
            for (int i = characters.size(); i < 3; i++) {
                characters.add(null);
            }
        }

        for (@Nullable Character character : characters) {
            final Button button = new Button();
            button.setStyle("-fx-border-color: Black");
            button.setStyle("-fx-font-size: 25px");

            if (character == null) {
                button.setText("New slot");
                button.setOnAction(event -> {
                    Main.app.changeScreen(new CreateCharacterScreen());
                });
            } else {
                button.setText(character.getName());
                button.setTooltip(new Tooltip(character.getName()));
                button.setOnAction(event -> {
                    Main.app.changeScreen(new CharacterDetailScreen(character));
                });
            }

            root.getChildren().add(button);
        }

        final Button deleteAccount = new Button("Delete Account");
        deleteAccount.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm deleting your account");
            alert.setHeaderText("Are you sure you want to delete your account?");
            alert.setContentText("If the account will be deleted, you will lose your progress in the game.");

            ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Delete");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Main.app.logout();
                if (new DeleteTask<User>().delete(user)) {
                    Main.app.changeScreen(new HomeScreen());
                }
            }
        });

        final Button logOutButton = new Button("Log out");
        logOutButton.setOnAction(event -> {
            Main.app.logout();
            Main.app.changeScreen(new HomeScreen());
        });

        root.getChildren().addAll(deleteAccount, logOutButton);

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        if (!Main.app.isUserLoggedIn()) {
            throw new RuntimeException("User must be logged in to enter save slot screen!");
        }
    }
}
