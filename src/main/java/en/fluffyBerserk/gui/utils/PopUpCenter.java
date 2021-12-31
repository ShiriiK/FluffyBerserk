package en.fluffyBerserk.gui.utils;

import en.fluffyBerserk.Main;
import javafx.stage.Popup;

public class PopUpCenter {

    public void centerPopUp(Popup popup){
        double x = Main.app.getPrimaryStage().getX() + 0.5*(Main.app.getPrimaryStage().getWidth()-300);
        popup.setX(x);

        double y  = Main.app.getPrimaryStage().getY() + 0.5*(Main.app.getPrimaryStage().getHeight()-500);
        popup.setY(y);
    }
}
