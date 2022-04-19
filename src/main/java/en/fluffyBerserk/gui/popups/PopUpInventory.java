package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.gamecontrolls.Game;

import en.fluffyBerserk.game.logic.objects.Entity;
import en.fluffyBerserk.game.logic.objects.items.inventory.Inventory;
import en.fluffyBerserk.game.logic.objects.items.potions.Potion;
import en.fluffyBerserk.gui.utils.AttachCSS;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

import java.util.Set;


public class PopUpInventory extends PopUp {

    @NotNull
    private final Game game;

    public PopUpInventory(Game game) {
        this.game = game;
    }

    protected void initPopUpStage() {
        Inventory playersInventory = Main.app.getGame().getInventory();

        BorderPane inventory = new BorderPane();
        FlowPane contetnt = new FlowPane();

       loadItems(contetnt, playersInventory);

        Button resumeButton = new Button("Close inventory");
        resumeButton.setOnAction(event -> {
            Main.app.hidePopUp();
            Main.app.getGame().getGameLoop().start();
        });

        inventory.setTop(contetnt);
        inventory.setBottom(resumeButton);

        inventory.getStyleClass().add("inventory");
        Scene scene = new Scene(inventory);
        scene.setFill(Color.TRANSPARENT);
        AttachCSS.attachCSS(scene);

        popUpStage.setScene(scene);
    }

    private void update(FlowPane contetnt, Inventory playersInventory) {
        contetnt.getChildren().clear();
        loadItems(contetnt, playersInventory);
    }

    public void loadItems(FlowPane contetnt, Inventory playersInventory) {
        Set<String> items = playersInventory.itemsInInventory();
        for(String name : items){
            Potion potion =  playersInventory.getItem(name);
            ImageView imageView = new ImageView(potion.getImage());
            imageView.setFitWidth(75);
            imageView.setFitHeight(75);

            Tooltip tooltip = new Tooltip();
            tooltip.setText("This is " + potion.getName() + " potion.");

            Tooltip.install(imageView, tooltip);

            imageView.setOnMouseClicked(event -> {
                potion.use();
                playersInventory.removeItem(name);
                update(contetnt, playersInventory);
                contetnt.getChildren().remove(this);
            });
            contetnt.getChildren().add(imageView);
        }
    }

    @Override
    public void onShow() {
        System.out.println("Inventory shown");
    }

    @Override
    public void onHide() {
        System.out.println("Inventory hidden");
    }


}
