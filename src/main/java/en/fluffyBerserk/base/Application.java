package en.fluffyBerserk.base;

import en.fluffyBerserk.persistence.DatabaseSession;
import en.fluffyBerserk.persistence.models.User;
import en.fluffyBerserk.logic.Game;
import en.fluffyBerserk.persistence.models.User;
import javafx.scene.effect.GaussianBlur;
import javafx.stage.*;
import en.fluffyBerserk.gui.popups.PopUp;
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

    @Nullable
    private User user;

    public Application(@NotNull Stage stage) {
        primaryStage = stage;
        init();
    }

    public void init() {
        primaryStage.setTitle("Fluffy Berserk");
        primaryStage.setHeight(500.0);
        primaryStage.setWidth(500.0);
        primaryStage.setOnCloseRequest(event -> {
            DatabaseSession.closeSession();
        });
    }

    public void start(Screen defaultScreen) {
        DatabaseSession.startSession();
        this.changeScreen(defaultScreen);
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
     * Redraws current scene from current screen
     */
    public void redrawScene() {
        if (currentScreen != null) {
            primaryStage.setScene(currentScreen.getScene());
        }
    }

    public void login(@NotNull User user) {
        this.user = user;
    }

    public void logout() {
        this.user = null;
    }

    public boolean isUserLoggedIn() {
        return user != null;
    }

    public @Nullable User getUser() {
        return user;
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
