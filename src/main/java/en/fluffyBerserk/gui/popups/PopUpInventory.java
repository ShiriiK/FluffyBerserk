package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.gamecontrolls.Game;

import en.fluffyBerserk.game.logic.objects.items.Item;
import en.fluffyBerserk.game.logic.objects.items.armor.Armor;
import en.fluffyBerserk.game.logic.objects.items.inventory.Inventory;
import en.fluffyBerserk.gui.utils.AttachCSS;

import en.fluffyBerserk.gui.utils.Handy;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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

        Set<String> items = playersInventory.itemsInInventory();
        for(String name : items){
            String path = "items/" + name + ".png";
            ImageView imageView = new ImageView(new Image(path, 50, 50, false, false));
            contetnt.getChildren().add(imageView);
        }

        Button resumeButton = new Button("Close inventory");
        resumeButton.setOnAction(event -> {
            Main.app.getGame().getGameLoop().start();
            Main.app.hidePopUp();
        });

        inventory.setTop(contetnt);
        inventory.setBottom(resumeButton);


        /**
        int m = 1;
        int n = 1;
        for (String itemName : items){
            String itemImageName = "/armor/" + itemName + ".png";
            Image image = new Image(itemImageName,50.0,50.0, true, true);
            ImageView imageView = new ImageView(image);
            Item item = playersInventory.getItem(itemName);

            if(!((Armor) item).isEquiped){
                imageView.setOnMouseClicked(event -> {
                    playersInventory.equip(item);
                    flowPane.getChildren().add(imageView);});
            }

            if(((Armor) item).isEquiped){
                imageView.setOnMouseClicked(event -> {
                    playersInventory.unEquip(item);;
                    flowPane.getChildren().remove(imageView);});

            }

            gridPane.add(imageView,m,n);
            if(m<5){
                m++;
            }
            if (m >= 5 && n < 2){
                n++;
                m++;
            }
            if (n==2 && m >= 5){
                n++;
                m++;
            }
        }

        gridPane.setGridLinesVisible(true);

        inventory.getChildren().addAll(resumeButton, label, gridPane, label1,flowPane);*/

        inventory.getStyleClass().add("inventory");
        Scene scene = new Scene(inventory);
        scene.setFill(Color.TRANSPARENT);
        AttachCSS.attachCSS(scene);

        popUpStage.setScene(scene);
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
