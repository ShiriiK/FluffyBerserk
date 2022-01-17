package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.Main;
import en.fluffyBerserk.game.gamecontrolls.Game;
import en.fluffyBerserk.game.logic.maps.Map2;
import en.fluffyBerserk.game.logic.maps.Map7;
import en.fluffyBerserk.game.logic.maps.SafeZoneMap;
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
                game.setCurrentMap(new SafeZoneMap()); //TODO creating new safe zone map not returning to old one
                Main.app.hidePopUp();
            }
        });

        Button area1 = new Button("Area 1");
        area1.setOnAction(event -> {
            if (!game.getCurrentMap().getName().equals("map2")) {
                game.setCurrentMap(new Map2());
                Main.app.hidePopUp();
            }
        });


        Button area2 = new Button("Area 2");

        Button area3 = new Button("Area 3");

        Button area4 = new Button("Area 4");
        area4.setOnAction(event -> {
            if (!game.getCurrentMap().getName().equals("map7")) {
                game.setCurrentMap(new Map7());
                Main.app.hidePopUp();
            }
        });


        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> {
            Main.app.hidePopUp();
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
