package main.java.en.fluffyBerserk.ui.popups;

import javafx.scene.Parent;

public interface PopUp {

    public Parent getRoot();

    public void onShow();

    public void onHide();
}
