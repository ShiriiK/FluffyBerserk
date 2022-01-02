package en.fluffyBerserk.gui.screens;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.form.SlotForm;
import en.fluffyBerserk.persistence.InsertTask;
import en.fluffyBerserk.persistence.models.Character;
import en.fluffyBerserk.persistence.models.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public final class CreateCharacterScreen extends BaseScreen {

    private final SlotForm form = new SlotForm();

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

        final Button createButton = new Button("Create");
        createButton.setOnAction(event -> {
            form.clearErrors();

            if (!form.validate()) {
                Main.app.redrawScene();
                return;
            }

            Character character = new Character();
            character.setName(form.getName());
            character.setArmor(form.getArmor());
            character.setIntellect(form.getIntellect());
            character.setStamina(form.getStamina());
            character.setStrength(form.getStrength());
            character.setUser(user);

            character = new InsertTask<Character>().insert(character);

            Main.app.changeScreen(new CharacterDetailScreen(character));
        });

        final Button backButton = new Button("Back to profile");
        backButton.setOnAction(event -> {
            Main.app.changeScreen(new SaveSlotsScreen());
        });

        final FlowPane buttonPane = new FlowPane();
        buttonPane.setHgap(5.0);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.getChildren().add(backButton);
        buttonPane.getChildren().add(createButton);

        root.getChildren().add(buttonPane);

        return new Scene(root);
    }

    @Override
    public void onEnter() {
        if (!Main.app.isUserLoggedIn()) {
            throw new RuntimeException("User must be logged in to enter slot screen!");
        }
    }
}
