package en.fluffyBerserk.base;

import javafx.scene.effect.GaussianBlur;
import javafx.stage.*;
import en.fluffyBerserk.gui.popups.PopUp;
import en.fluffyBerserk.gui.screens.TestScreen1;
import en.fluffyBerserk.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Application {

    @NotNull
    private final Stage primaryStage;

    @Nullable
    private Screen currentScreen;

    @Nullable
    private PopUp currentPopUp;

    public Application(@NotNull Stage stage) {
        primaryStage = stage;
        init();

        // Set default screen
        this.changeScreen(new TestScreen1());
    }

    public void init() {
        primaryStage.setTitle("Fluffy Berserk");
        primaryStage.setHeight(500.0);
        primaryStage.setWidth(500.0);
    }

    public void start() {
        primaryStage.show();
    }

    public @NotNull Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Changes current screen to another and triggers
     * specific hooks
     */
    public void changeScreen(@NotNull Screen screen) {
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
    public void showPopUp(@NotNull PopUp popUp) {
        if (currentPopUp != null) {
            hidePopUp();
        }

        popUp.onShow();

        setCurrentPopUp(popUp);

        popUp.getPopUpStage().show();

        if (currentScreen != null) { // Add gaussian blur effect
            currentScreen.getScene().getRoot().setEffect(new GaussianBlur());
        }
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

        if (currentScreen != null) { // Remove gaussian blur effect
            currentScreen.getScene().getRoot().setEffect(null);
        }
    }

    /**
     * Sets a pop-up instance as a current pop-up
     */
    private void setCurrentPopUp(@Nullable PopUp currentPopUp) {
        this.currentPopUp = currentPopUp;
    }

    /**
     * Sets a screen instance as a current screen
     */
    private void setCurrentScreen(@NotNull Screen currentScreen) {
        this.currentScreen = currentScreen;

        // Change the screen on primary stage
        primaryStage.setScene(currentScreen.getScene());
    }
}
