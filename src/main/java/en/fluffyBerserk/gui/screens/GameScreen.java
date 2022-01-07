package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.popups.PopUpMenu;
import en.fluffyBerserk.persistence.models.Character;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import org.jetbrains.annotations.NotNull;

public final class GameScreen extends Screen {

    @NotNull
    private final Character character;

    public GameScreen(@NotNull final Character character) {
        this.character = character;
        // TODO GAME
    }

    @Override
    protected Scene buildScene() {
        final BorderPane root = new BorderPane();

        root.getChildren().add(new Label("Game with character " + character.getName()));

        final Scene scene = new Scene(root);

        // Attach event on scene for displaying menu
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                Main.app.showPopUp(new PopUpMenu());
            }
        });

        return scene;
    }

    @Override
    public void onEnter() {
        if (!Main.app.isUserLoggedIn()) {
            throw new RuntimeException("User must be logged in to enter game screen!");
        }
        System.out.println("Entered game screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left game screen");
    }
}
