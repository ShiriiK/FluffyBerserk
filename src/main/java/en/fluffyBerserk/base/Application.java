package en.fluffyBerserk.base;

import javafx.scene.effect.GaussianBlur;
import javafx.stage.*;
import en.fluffyBerserk.ui.popups.PopUp;
import en.fluffyBerserk.ui.screens.TestScreen1;
import en.fluffyBerserk.ui.screens.Screen;

public final class Application {

    private final Stage primaryStage;

    private Screen currentScreen;

    private PopUp currentPopUp;

    public Application(Stage stage) {
        primaryStage = stage;
        init();
    }

    public void init() {
        primaryStage.setTitle("Fluffy Berserk");

        primaryStage.setHeight(500.0);
        primaryStage.setWidth(500.0);

        // Set default screen
        this.changeScreen(new TestScreen1());
    }

    public void start() {
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Changes current screen to another and triggers
     * specific hooks
     */
    public void changeScreen(Screen screen) {
        if (currentScreen != null) {
            currentScreen.onLeave();
        }

        // Hide pop-up if changing screens
        if (currentPopUp != null) {
            hidePopUp();
        }

        setCurrentScreen(screen);

        currentScreen.onEnter();
    }

    /**
     * Shows given pop-up instance and hides
     * current pop-up if any
     */
    public void showPopUp(PopUp popUp) {
        if (currentPopUp != null) {
            hidePopUp();
        }

        popUp.onShow();

        currentScreen.getScene().getRoot().setEffect(new GaussianBlur());

        setCurrentPopUp(popUp);

        popUp.getPopUpStage().show();
    }

    /**
     * Hides current shown pop-up if any
     */
    public void hidePopUp() {
        if (currentPopUp == null) {
            return;
        }

        currentPopUp.onHide();
        currentPopUp.getPopUpStage().hide();

        setCurrentPopUp(null);

        // Remove gaussian blur effect
        currentScreen.getScene().getRoot().setEffect(null);
    }

    /**
     * Sets a pop-up instance as a current pop-up
     */
    private void setCurrentPopUp(PopUp currentPopUp) {
        this.currentPopUp = currentPopUp;
    }

    /**
     * Sets a screen instance as a current screen
     */
    private void setCurrentScreen(Screen currentScreen) {
        this.currentScreen = currentScreen;

        // Change the screen on primary stage
        primaryStage.setScene(currentScreen.getScene());
    }
}
