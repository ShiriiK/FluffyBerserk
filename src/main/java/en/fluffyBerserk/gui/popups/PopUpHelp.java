package en.fluffyBerserk.gui.popups;

import javafx.scene.Scene;
import javafx.scene.web.WebView;

/**
 * BasePopUp extension class that displays help.
 */

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
