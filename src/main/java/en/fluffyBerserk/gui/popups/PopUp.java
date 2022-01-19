package en.fluffyBerserk.gui.popups;

import en.fluffyBerserk.gui.nodes.NodesFactory;
import en.fluffyBerserk.gui.utils.PopUpBuilder;
import javafx.stage.Stage;

/**
 * This class serves as an abstract base class for all pop-ups
 */
public abstract class PopUp {

    protected NodesFactory factory = new NodesFactory();
    protected final Stage popUpStage;

    // Structure of PopUp
    public PopUp() {
        popUpStage = PopUpBuilder.buildDefaultStage();
        initPopUpStage();
    }

    public Stage getPopUpStage() {
        return popUpStage;
    }

    // Abstract methods

    protected abstract void initPopUpStage();

    public abstract void onShow();

    public abstract void onHide();
}
