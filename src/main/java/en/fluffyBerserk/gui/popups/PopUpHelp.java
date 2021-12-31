package en.fluffyBerserk.gui.popups;

import javafx.scene.web.WebView;

/**
 * BasePopUp extension class that displays help.
 */

public final class PopUpHelp extends BasePopUp {

    @Override
    protected void initPopUpStage() {
        WebView view = new WebView();
        view.getEngine().load(getClass().getResource("/other/help.html").toExternalForm());

        popup.getContent().add(view);
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
