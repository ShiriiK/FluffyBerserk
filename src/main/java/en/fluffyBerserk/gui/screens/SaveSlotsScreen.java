package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.graphics.sprites.SpriteImage;
import en.fluffyBerserk.gui.graphics.sprites.SpritesFactory;
import en.fluffyBerserk.gui.utils.AttachCSS;
import en.fluffyBerserk.persistence.DeleteTask;
import en.fluffyBerserk.persistence.SelectTask;
import en.fluffyBerserk.persistence.models.Character;
import en.fluffyBerserk.persistence.models.User;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.Nullable;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public final class SaveSlotsScreen extends BaseScreen {

    private Scene scene;
    private VBox bottomButtons, topButtons;

    @Override
    protected Scene buildScene() {

        final User user = Main.app.getUser();
        assert user != null;

        init();
        loadSaveSlots(user);
        prepareButtons(user);

        return scene;
    }

    private void prepareButtons(User user) {
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

        bottomButtons.getChildren().addAll(deleteAccount, logOutButton);
    }

    private void loadSaveSlots(User user) {
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
                    Main.app.changeScreen(new CharacterScreen(null));
                });
            } else {
                button.setText(character.getName());
                button.setTooltip(new Tooltip(character.getName()));
                button.setOnAction(event -> {
                    Main.app.changeScreen(new CharacterScreen(character));
                });
                Image image = new SpriteImage(SpritesFactory.getSpriteByNumber(character.getSpriteIndex()), 32, 0, 32, 32).getFrame();
                button.setGraphic(new ImageView(image));
                button.setContentDisplay(ContentDisplay.LEFT);
            }

            topButtons.getChildren().add(button);
        }
    }

    private void init(){
        VBox root = new VBox();
        root.getStyleClass().add("vbox");

        topButtons = new VBox();
        topButtons.getStyleClass().add("vbox");

        bottomButtons = new VBox();
        bottomButtons.getStyleClass().add("vbox-bottom");

        root.getChildren().addAll(topButtons, bottomButtons);

        scene = new Scene(root);
        AttachCSS.attachCSS(scene);
    }

    @Override
    public void onEnter() {
        if (!Main.app.isUserLoggedIn()) {
            throw new RuntimeException("User must be logged in to enter save slot screen!");
        }
    }
}
