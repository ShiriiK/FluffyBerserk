package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.form.CharacterForm;
import en.fluffyBerserk.gui.animations.SpriteImage;
import en.fluffyBerserk.gui.animations.SpritesFactory;
import en.fluffyBerserk.gui.utils.LocateImage;
import en.fluffyBerserk.persistence.DeleteTask;
import en.fluffyBerserk.persistence.InsertTask;
import en.fluffyBerserk.persistence.UpdateTask;
import en.fluffyBerserk.persistence.models.Character;
import en.fluffyBerserk.persistence.models.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public final class CharacterEditScreen extends BaseScreen {

    private final CharacterForm form;

    @Nullable
    private final Character character;

    public CharacterEditScreen(@Nullable Character character) {
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

        final VBox root = new VBox();
        root.setPadding(new Insets(15, 15, 15, 15));
        root.setSpacing(10.0);
        root.setAlignment(Pos.CENTER);

        final Label nameLabel = new Label("Character name");
        final TextField nameField = new TextField();
        nameField.setText(form.getName());
        nameField.setPromptText("Enter character name");
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            form.setName(newValue);
        });

        root.getChildren().add(nameLabel);
        root.getChildren().add(nameField);

        // Render errors if any
        for (String error : form.getErrorsForField("name")) {
            Text errorText = new Text(error);
            errorText.setFill(Color.RED);
            root.getChildren().add(errorText);
        }

        final HBox characterBox = new HBox();
        characterBox.setAlignment(Pos.CENTER);

        final ImageView characterView = new ImageView(new SpriteImage(form.getSprite(), 32, 0, 32, 32).getFrame());
        characterView.setFitHeight(128);
        characterView.setFitWidth(128);

        final Button buttonPrevious = new Button("<<<");
        buttonPrevious.getStyleClass().add("button-edit");
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

        final Button buttonNext = new Button(">>>");
        buttonNext.getStyleClass().add("button-edit");
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
        root.getChildren().add(characterBox);

        final Label pointsLeftLabel = new Label(String.format("Points left: %d", form.getPointsLeft()));

        root.getChildren().add(pointsLeftLabel);

        final Label staminaLabel = new Label("Stamina");
        final Spinner<Integer> staminaSpinner = new Spinner<>();
        staminaSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, form.getPointsLeft() + form.getStamina(), form.getStamina()));

        root.getChildren().add(staminaLabel);
        root.getChildren().add(staminaSpinner);

        final Label strengthLabel = new Label("Strength");
        final Spinner<Integer> strengthSpinner = new Spinner<>();
        strengthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, form.getPointsLeft() + form.getStrength(), form.getStrength()));

        root.getChildren().add(strengthLabel);
        root.getChildren().add(strengthSpinner);

        final Label armorLabel = new Label("Armor");
        final Spinner<Integer> armorSpinner = new Spinner<>();
        armorSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, form.getPointsLeft() + form.getArmor(), form.getArmor()));

        root.getChildren().add(armorLabel);
        root.getChildren().add(armorSpinner);

        final Label intellectLabel = new Label("Intellect");
        final Spinner<Integer> intellectSpinner = new Spinner<>();
        intellectSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, form.getPointsLeft() + form.getIntellect(), form.getIntellect()));

        root.getChildren().add(intellectLabel);
        root.getChildren().add(intellectSpinner);

        // Render errors if any
        for (String error : form.getErrorsForField("points")) {
            Text errorText = new Text(error);
            errorText.setFill(Color.RED);
            root.getChildren().add(errorText);
        }

        staminaSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue > newValue) {
                form.decrementStamina();
                form.incrementPointsLeft();
            } else {
                form.incrementStamina();
                form.decrementPointsLeft();
            }
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) intellectSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getIntellect());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) armorSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getArmor());
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
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) intellectSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getIntellect());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) armorSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getArmor());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) strengthSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getStrength());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) staminaSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getStamina());

            pointsLeftLabel.setText(String.format("Points left: %d", form.getPointsLeft()));
        });

        armorSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue > newValue) {
                form.decrementArmor();
                form.incrementPointsLeft();
            } else {
                form.incrementArmor();
                form.decrementPointsLeft();
            }
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) intellectSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getIntellect());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) armorSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getArmor());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) strengthSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getStrength());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) staminaSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getStamina());

            pointsLeftLabel.setText(String.format("Points left: %d", form.getPointsLeft()));
        });

        intellectSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue > newValue) {
                form.decrementIntellect();
                form.incrementPointsLeft();
            } else {
                form.incrementIntellect();
                form.decrementPointsLeft();
            }
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) intellectSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getIntellect());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) armorSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getArmor());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) strengthSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getStrength());
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) staminaSpinner.getValueFactory()).setMax(form.getPointsLeft() + form.getStamina());

            pointsLeftLabel.setText(String.format("Points left: %d", form.getPointsLeft()));
        });

        final Button continueButton;
        if (!Main.app.isUserLoggedIn()) {
            continueButton = new Button("Play");
        } else if (character != null) {
            continueButton = new Button("Save");
        } else {
            continueButton = new Button("Create");
        }

        continueButton.setOnAction(event -> {
            form.clearErrors();

            if (!form.validate()) {
                Main.app.redrawScene();
                return;
            }

            Character newCharacter;
            if (character == null) {
                newCharacter = new Character();
            } else {
                newCharacter = character;
            }

            newCharacter.setName(form.getName());
            newCharacter.setArmor(form.getArmor());
            newCharacter.setIntellect(form.getIntellect());
            newCharacter.setStamina(form.getStamina());
            newCharacter.setStrength(form.getStrength());
            newCharacter.setSpriteIndex(form.getSprite().getIndex());

            if (!Main.app.isUserLoggedIn()) {
                Main.app.changeScreen(new GameScreen(newCharacter));
                return;
            }

            newCharacter.setUser(user);

            if (character == null) {
                new InsertTask<Character>().insert(newCharacter);
            } else {
                new UpdateTask<Character>().update(newCharacter);
            }

            Main.app.changeScreen(new SaveSlotsScreen());
        });

        final FlowPane buttonPane = new FlowPane();
        buttonPane.setHgap(5.0);
        buttonPane.setAlignment(Pos.CENTER);

        if (Main.app.isUserLoggedIn()) {
            final Button backButton = new Button("Back to profile");
            backButton.setOnAction(event -> {
                Main.app.changeScreen(new SaveSlotsScreen());
            });
        }

        if (character != null) {
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
            buttonPane.getChildren().add(deleteButton);
        }

        buttonPane.getChildren().add(continueButton);

        root.getChildren().add(buttonPane);

        return new Scene(root);
    }
}
