package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.game.Game;
import en.fluffyBerserk.gui.utils.AttachCSS;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public final class PopUpHelp extends PopUp {

    @Override
    protected void initPopUpStage() {
        WebView view = new WebView();
        view.getEngine().load(getClass().getResource("/other/help.html").toExternalForm());

        Scene scene = new Scene(view);
        AttachCSS.attachCSS(scene);

        popUpStage.setScene(scene);
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
