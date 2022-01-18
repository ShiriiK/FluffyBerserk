package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.gamecontrolls.Game;

import en.fluffyBerserk.game.logic.objects.items.Item;
import en.fluffyBerserk.game.logic.objects.items.armor.Armor;
import en.fluffyBerserk.gui.utils.AttachCSS;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

        VBox inventory = new VBox();
        GridPane gridPane = new GridPane();
        FlowPane flowPane = new FlowPane();

        Label label = new Label("Inventory");
        Label label1 = new Label("Equiped items");

        Button resumeButton = new Button("Resume");
        resumeButton.setOnAction(event -> Main.app.hidePopUp());
        Set<String> items = Game.inventory.itemsInInventory();

        int m = 1;
        int n = 1;


        for (String itemName : items){
            String itemImageName = "/armor/" + itemName + ".png";
            Image image = new Image(itemImageName,50.0,50.0, true, true);
            ImageView imageView = new ImageView(image);
            Item item = Game.inventory.getItem(itemName);

            if(!((Armor) item).isEquiped){
                imageView.setOnMouseClicked(event -> {
                    Game.inventory.equip(item);
                    flowPane.getChildren().add(imageView);});
            }

            if(((Armor) item).isEquiped){
                imageView.setOnMouseClicked(event -> {
                    Game.inventory.unEquip(item);;
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

        inventory.getChildren().addAll(resumeButton, label, gridPane, label1,flowPane);

        inventory.getStyleClass().add("pop-up-menu");
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
