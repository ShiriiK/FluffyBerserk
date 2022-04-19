package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.maps.*;
import en.fluffyBerserk.gui.screens.HomeScreen;
import en.fluffyBerserk.gui.utils.AttachCSS;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PopUpPortal extends PopUp {

    @Override
    protected void initPopUpStage() {
        Game game = Main.app.getGame();
        VBox buttons = new VBox();

        Button safeZone = new Button("Safe zone");
        safeZone.setOnAction(event -> {
            if (!game.getCurrentMap().getName().equals("map1")) {
                game.playerSpawner.spawnOnMap(1);
                game.setCurrentMap(game.getCurrentMap().loadMapById(1));
                Main.app.hidePopUp();
                Main.app.getGame().getGameLoop().start();
            }
        });

        Button area1 = new Button("Area 1");
        area1.setOnAction(event -> {
            if (!game.getCurrentMap().getName().equals("map3")) {
                game.playerSpawner.spawnOnMap(3);
                game.setCurrentMap(game.map3);
                Main.app.hidePopUp();
                Main.app.getGame().getGameLoop().start();
            }
        });


        Button area2 = new Button("Area 2");
        area2.setOnAction(event -> {
            if (!game.getCurrentMap().getName().equals("map4")) {
                game.playerSpawner.spawnOnMap(4);
                game.setCurrentMap(game.map4);
                Main.app.hidePopUp();
                Main.app.getGame().getGameLoop().start();
            }
        });

        if (game.getPhase() < game.map4.getPhase()){
            area2.setDisable(true);
        }

        Button area3 = new Button("Area 3");
        area3.setOnAction(event -> {
            if (!game.getCurrentMap().getName().equals("map5")) {
                game.playerSpawner.spawnOnMap(5);
                game.setCurrentMap(game.map5);
                Main.app.hidePopUp();
                Main.app.getGame().getGameLoop().start();
            }
        });
        if (game.getPhase() < game.map5.getPhase()){
            area3.setDisable(true);
        }

        Button area4 = new Button("Area 4");
        area4.setOnAction(event -> {
            if (!game.getCurrentMap().getName().equals("map6")) {
                game.playerSpawner.spawnOnMap(6);
                game.setCurrentMap(game.map6);
                Main.app.hidePopUp();
                Main.app.getGame().getGameLoop().start();
            }
        });
        if (game.getPhase() < game.map6.getPhase()){
            area4.setDisable(true);
        }

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
