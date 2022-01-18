package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.form.CharacterForm;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.gui.graphics.sprites.SpriteImage;
import en.fluffyBerserk.gui.graphics.sprites.SpritesFactory;
import en.fluffyBerserk.gui.utils.AttachCSS;
import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.persistence.DeleteTask;
import en.fluffyBerserk.persistence.InsertTask;
import en.fluffyBerserk.persistence.UpdateTask;
import en.fluffyBerserk.persistence.models.Character;
import en.fluffyBerserk.persistence.models.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public final class CharacterScreen extends BaseScreen {

    @NotNull
    private final CharacterForm form;

    @Nullable
    private final Character character;

    private Scene scene;
    private HBox root, box1, box2;
    private VBox leftBox, rightBox;

    public CharacterScreen(@Nullable Character character) {
        if (character == null) {
            form = new CharacterForm(null);
        } else {
            form = new CharacterForm(character);
        }
        this.character = character;
    }

    @Override
    protected Scene buildScene() {
        User user = Main.app.getUser();
        assert user != null;

        init();

        setUpCharacterNameFieldStuff();
        setUpCharacterImageWithButtons();
        setUpStatsSettings();
        setUpButtons(user);


        return scene;
    }

    private void setUpButtons(User user) {
        if (!Main.app.isUserLoggedIn()) { // guest account
            final Button backToHomeButton = new Button("Back");
            backToHomeButton.setOnAction(event -> {
                Main.app.changeScreen(new HomeScreen());
            });

            final Button guestPlayButton = new Button("Play");
            guestPlayButton.setOnAction(event -> {
                form.clearErrors();

                if (!form.validate()) {
                    Main.app.redrawScene();
                    return;
                }

                final Character newCharacter = new Character();
                newCharacter.setName(form.getName());
                newCharacter.setArmor(form.getArmor());
                newCharacter.setIntellect(form.getIntellect());
                newCharacter.setStamina(form.getStamina());
                newCharacter.setStrength(form.getStrength());
                newCharacter.setSpriteIndex(form.getSprite().getIndex());

                Main.app.changeScreen(new GameScreen(newCharacter));
            });

            rightBox.getChildren().addAll(
                    backToHomeButton,
                    guestPlayButton
            );
        } else if (character == null) { // logged user is creating character
            final Button backToProfileButton = new Button("Back");
            backToProfileButton.setOnAction(event -> {
                Main.app.changeScreen(new SaveSlotsScreen());
            });

            final Button createButton = new Button("Create");
            createButton.setOnAction(event -> {
                form.clearErrors();

                if (!form.validate()) {
                    Main.app.redrawScene();
                    return;
                }

                Character newCharacter = new Character();
                newCharacter.setName(form.getName());
                newCharacter.setArmor(form.getArmor());
                newCharacter.setIntellect(form.getIntellect());
                newCharacter.setStamina(form.getStamina());
                newCharacter.setStrength(form.getStrength());
                newCharacter.setSpriteIndex(form.getSprite().getIndex());
                newCharacter.setUser(user);

                new InsertTask<Character>().insert(newCharacter);

                Main.app.changeScreen(new SaveSlotsScreen());
            });

            rightBox.getChildren().addAll(
                    backToProfileButton,
                    createButton
            );
        } else { // logged user is viewing detail of existing character
            final Button backToProfileButton = new Button("Back");
            backToProfileButton.setOnAction(event -> {
                Main.app.changeScreen(new SaveSlotsScreen());
            });

            final Button saveButton = new Button("Save character");
            saveButton.setOnAction(event -> {
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

                new UpdateTask<Character>().update(character);

                Main.app.changeScreen(new SaveSlotsScreen());
            });

            final Button deleteButton = new Button("Delete character");
            deleteButton.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm deleting your character");
                alert.setHeaderText("Are you sure you want to delete your character?");
                alert.setContentText("If the character will be deleted, you will lose your progress in the game.");

                ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Delete");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    if (new DeleteTask<Character>().delete(character)) {
                        Main.app.changeScreen(new SaveSlotsScreen());
                    }
                }
            });

            final Button playButton = new Button("Play");
            playButton.setOnAction(event -> {

                if (Main.app.getGame() != null) {
                    if (Main.app.getGame().running) {
                        Game game = Main.app.getGame();
                        Main.app.changeScreen(Main.app.getGame().gameScreen); //TODO now just save this to database
                        game.setCurrentMap(Main.app.getGame().getCurrentMap());
                        game.getGameLoop().start();
                        System.out.println("Back in same game");
                    }

                } else {
                    Main.app.changeScreen(new GameScreen(character));
                }

            });

            rightBox.getChildren().addAll(backToProfileButton, playButton);
            leftBox.getChildren().addAll(deleteButton, saveButton);
        }
    }

    private void setUpStatsSettings() {
        final Label pointsLeftLabel = new Label(String.format("Points left: %d", form.getPointsLeft()));

        rightBox.getChildren().add(pointsLeftLabel);

        final Label staminaLabel = new Label("Stamina");
        final Spinner<Integer> staminaSpinner = new Spinner<>();
        staminaSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, form.getPointsLeft() + form.getStamina(), form.getStamina()));

        rightBox.getChildren().add(staminaLabel);
        rightBox.getChildren().add(staminaSpinner);

        final Label strengthLabel = new Label("Strength");
        final Spinner<Integer> strengthSpinner = new Spinner<>();
        strengthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, form.getPointsLeft() + form.getStrength(), form.getStrength()));

        rightBox.getChildren().add(strengthLabel);
        rightBox.getChildren().add(strengthSpinner);

        // Render errors if any
        for (String error : form.getErrorsForField("points")) {
            Text errorText = new Text(error);
            errorText.setFill(Color.RED);
            rightBox.getChildren().add(errorText);
        }

        staminaSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue > newValue) {
                form.decrementStamina();
                form.incrementPointsLeft();
            } else {
                form.incrementStamina();
                form.decrementPointsLeft();
            }
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) strengthSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getStrength());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) staminaSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getStamina());

            pointsLeftLabel.setText(String.format("Points left: %d", form.getPointsLeft()));
        });

        strengthSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue > newValue) {
                form.decrementStrength();
                form.incrementPointsLeft();
            } else {
                form.incrementStrength();
                form.decrementPointsLeft();
            }
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) strengthSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getStrength());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) staminaSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getStamina());

            pointsLeftLabel.setText(String.format("Points left: %d", form.getPointsLeft()));
        });

    }

    private void setUpCharacterImageWithButtons() {
        final HBox characterBox = new HBox();
        characterBox.setAlignment(Pos.CENTER);

        final ImageView characterView = new ImageView(new SpriteImage(form.getSprite(), 32, 0, 32, 32).getFrame());
        characterView.setFitHeight(256);
        characterView.setFitWidth(256);

        final Button buttonPrevious = new Button("<");
        buttonPrevious.getStyleClass().add("back-button");
        buttonPrevious.setOnAction(event -> {
            int newIndex = form.getSprite().getIndex() - 1;

            if (!SpritesFactory.indexExists(newIndex)) {
                return;
            }

            final LocateImage newSprite = SpritesFactory.getSpriteByNumber(newIndex);
            assert newSprite != null;

            form.setSprite(newSprite);

            characterView.setImage(new SpriteImage(form.getSprite(), 32, 0, 32, 32).getFrame());
        });

        final Button buttonNext = new Button(">");
        buttonNext.getStyleClass().add("back-button");
        buttonNext.setOnAction(event -> {
            int newIndex = form.getSprite().getIndex() + 1;

            if (!SpritesFactory.indexExists(newIndex)) {
                return;
            }

            final LocateImage newSprite = SpritesFactory.getSpriteByNumber(newIndex);
            assert newSprite != null;

            form.setSprite(newSprite);

            characterView.setImage(new SpriteImage(form.getSprite(), 32, 0, 32, 32).getFrame());
        });

        characterBox.getChildren().addAll(buttonPrevious, characterView, buttonNext);
        leftBox.getChildren().add(characterBox);

        final Button randomSpriteButton = new Button("Random character");
        randomSpriteButton.setOnAction(event -> {
            final LocateImage randomSprite = SpritesFactory.getRandomSprite();

            form.setSprite(randomSprite);

            characterView.setImage(new SpriteImage(randomSprite, 32, 0, 32, 32).getFrame());
        });

        leftBox.getChildren().add(randomSpriteButton);
    }

    private void setUpCharacterNameFieldStuff() {
        final Label nameLabel = new Label("Character name");
        final TextField nameField = new TextField();
        nameField.setText(form.getName());
        nameField.setPromptText("Enter character name");
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            form.setName(newValue);
        });

        leftBox.getChildren().add(nameLabel);
        leftBox.getChildren().add(nameField);

        // Render errors if any
        for (String error : form.getErrorsForField("name")) {
            Text errorText = new Text(error);
            errorText.setFill(Color.RED);
            leftBox.getChildren().add(errorText);
        }
    }

    private void init() {
        root = new HBox();
        root.getStyleClass().add("vbox");
        root.getStyleClass().add("character-screen");

        leftBox = new VBox();
        leftBox.getStyleClass().add("vbox");

        rightBox = new VBox();
        rightBox.getStyleClass().add("vbox");

        box1 = new HBox();
        box2 = new HBox();

        leftBox.getChildren().addAll(box1, box2);
        root.getChildren().addAll(leftBox, rightBox);

        scene = new Scene(root);
        AttachCSS.attachCSS(scene);
    }
}
