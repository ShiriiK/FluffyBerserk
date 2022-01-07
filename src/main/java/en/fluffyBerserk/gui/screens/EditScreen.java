package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.gui.animations.MovableEntityAnimations;
import en.fluffyBerserk.gui.animations.SpriteImage;
import en.fluffyBerserk.gui.utils.AttachCSS;
import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.gui.animations.SpritesFactory;
import en.fluffyBerserk.logic.objects.creatures.player.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Screen representing Character creation/edit screen
 */
public class EditScreen extends Screen {
    private final LocateImage[] skin = SpritesFactory.getImages();
    private MovableEntityAnimations playerAnimations = Player.getPlayerAnimations();
    private SpriteImage currentPlayerSkin = new SpriteImage(playerAnimations.getUsedSprite(), 32, 0, 32, 32);
    private SpriteImage pickedSkin = currentPlayerSkin;
    private int index = playerAnimations.getUsedSprite().getIndex();

    @Override
    protected Scene buildScene() {
        VBox root = new VBox();

        Label label1 = new Label("Character name");
        TextField name = new TextField("enter name");

        // Safe-zone
        Button saveCharacter = new Button("Save character");
        saveCharacter.setOnAction(event -> {
            try {
                Main.app.changeScreen(new SafeZoneScreen());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Player.changeAnimationsSprite(SpritesFactory.getImages()[index]);
        });

        ///// Character image /////
        HBox hBox = new HBox();

        ImageView playerView = new ImageView(pickedSkin.getFrame());
        playerView.setFitHeight(128);
        playerView.setFitWidth(128);

        Button buttonPerv = new Button("<<<");
        buttonPerv.getStyleClass().add("button-edit");
        buttonPerv.setOnAction(event -> {
            for (LocateImage sprite : skin) {
                if (sprite.getIndex() == index) {
                    if (index == (0)) {
                        index = (skin.length - 1);
                    } else {
                        index--;
                    }
                    pickedSkin = new SpriteImage(SpritesFactory.getImages()[index], 32, 0, 32, 32);
                    playerView.setImage(pickedSkin.getFrame());
                    System.out.println(index);
                    break;
                }
            }
        });

        Button buttonNext = new Button(">>>");
        buttonNext.getStyleClass().add("button-edit");
        buttonNext.setOnAction(event -> {
            for (LocateImage sprite : skin) {
                if (sprite.getIndex() == index) {
                    if (index == (skin.length - 1)) {
                        index = 0;
                    } else {
                        index++;
                    }
                    pickedSkin = new SpriteImage(SpritesFactory.getImages()[index], 32, 0, 32, 32);
                    playerView.setImage(pickedSkin.getFrame());
                    System.out.println(index);
                    break;
                }
            }
        });

        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(buttonPerv, playerView, buttonNext);
        ///// Character image /////


        // Save slots
        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> Main.app.changeScreen(new SaveSlotsScreen()));

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label1, name, hBox, saveCharacter, cancel);

        Scene scene = new Scene(root);
        AttachCSS.attachCSS(scene);

        return scene;
    }

    @Override
    public void onEnter() {
        System.out.println("Entered edit screen");
    }

    @Override
    public void onLeave() {
        System.out.println("Left edit screen");
    }
}
