package en.fluffyBerserk.gui.popups;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import en.fluffyBerserk.base.Main;
import en.fluffyBerserk.gui.screens.TestScreen1;
import javafx.scene.web.WebView;

public final class PopUpHelp extends BasePopUp {

    @Override
    protected String getPopUpTitle() {
        return "Test pop-up 2";
    }

    @Override
    protected void initPopUpStage() {
        WebView view = new WebView();
        view.getEngine().load(getClass().getResource("/other/help.html").toExternalForm());

        popUpStage.setScene(new Scene(view));
    }

    @Override
    public void onShow() {
        System.out.println("Help shown");
    }

    @Override
    public void onHide() {
        System.out.println("Help hidden");
    }
}
