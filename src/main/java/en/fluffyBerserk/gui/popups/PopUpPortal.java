package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.maps.*;
import en.fluffyBerserk.gui.utils.AttachCSS;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PopUpPortal extends PopUp {
    private Game game;

    public PopUpPortal(Game game) {
        this.game = game;
    }

    @Override
    protected void initPopUpStage() {
        VBox buttons = new VBox();

        Button safeZone = new Button("Safe zone");

        safeZone.setOnAction(event -> {
            if (!game.getCurrentMap().getName().equals("map1")) {
                game.setCurrentMap(game.map1); //TODO creating new safe zone map not returning to old one
                Main.app.hidePopUp();
                Main.app.getGame().getGameLoop().start();
            }
        });

        Button area1 = new Button("Area 1");
        area1.setOnAction(event -> {
            if (!game.getCurrentMap().getName().equals("map3")) {
                if (game.map3 == null){
                    game.map3 = new Map3();
                    game.setCurrentMap(game.map3);
                } else {
                    game.setCurrentMap(game.map3);
                }
                Main.app.hidePopUp();
                Main.app.getGame().getGameLoop().start();
            }
        });


        Button area2 = new Button("Area 2");
        area2.setOnAction(event -> {
            if (game.map4 == null){
                game.map4 = new Map4();
                game.setCurrentMap(game.map4);
            } else {
                game.setCurrentMap(game.map4);
            }
            Main.app.hidePopUp();
            Main.app.getGame().getGameLoop().start();
        });

        Button area3 = new Button("Area 3");
        area3.setOnAction(event -> {
            if (game.map5 == null){
                game.map5 = new Map3(); // TODO
                game.setCurrentMap(game.map5);
            } else {
                game.setCurrentMap(game.map5);
            }
            Main.app.hidePopUp();
            Main.app.getGame().getGameLoop().start();
        });

        Button area4 = new Button("Area 4");
        area4.setOnAction(event -> {
            if (!game.getCurrentMap().getName().equals("map6")) {
                if (game.map6 == null){
                    game.map6 = new Map6();
                    game.setCurrentMap(game.map6);
                } else {
                    game.setCurrentMap(game.map6);
                }
                Main.app.hidePopUp();
                Main.app.getGame().getGameLoop().start();
            }
        });


        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> {
            Main.app.hidePopUp();
            Main.app.getGame().getGameLoop().start();
        });

        buttons.getChildren().addAll(safeZone, area1, area2, area3, area4, cancel);
        buttons.getStyleClass().add("pop-up-menu");



        Scene scene = new Scene(buttons);
        scene.setFill(Color.TRANSPARENT);
        AttachCSS.attachCSS(scene);

        popUpStage.setScene(scene);
    }

    @Override
    public void onShow() {
        System.out.println("Portal shown");
    }

    @Override
    public void onHide() {
        System.out.println("Portal hidden");
    }
}
