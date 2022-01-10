package en.fluffyBerserk.base;

import en.fluffyBerserk.gui.popups.PopUp;
import en.fluffyBerserk.gui.screens.Screen;
import en.fluffyBerserk.gui.utils.PopUpBuilder;
import en.fluffyBerserk.invariables.Constant;
import en.fluffyBerserk.persistence.DatabaseSession;
import en.fluffyBerserk.persistence.models.User;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The core of the application, where the primaryStage is created
 * and where the scenes for it are swapped when needed
 * as well as pop-ups are being displayed and hidden.
 */
public final class Application {

    public static final String APP_NAME = "Fulffy Berserk";

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
        primaryStage.setTitle(APP_NAME);
        primaryStage.setHeight(Constant.SCREEN_HEIGHT);
        primaryStage.setWidth(Constant.SCREEN_WIDTH);
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
     * Sets a screen instance as a current screen
     */
    private void setCurrentScreen(@NotNull Screen currentScreen) {
        this.currentScreen = currentScreen;
        primaryStage.setScene(currentScreen.getScene());
    }

    /**
     * Changes current screen to another and triggers
     * specific hooks
     */
    public void changeScreen(@NotNull Screen screen) {
        if (currentScreen != null) {
            currentScreen.onLeave();
        }

        if (currentPopUp != null) {
            hidePopUp();
        }

        setCurrentScreen(screen);
        currentScreen.onEnter();
    }

    /**
     * Redraws current scene from current screen
     */
    public void redrawScene() {
        if (currentScreen != null) {
            primaryStage.setScene(currentScreen.getScene());
        }
    }

    /**
     * Sets a pop-up instance as a current pop-up
     */
    private void setCurrentPopUp(@Nullable PopUp currentPopUp) {
        this.currentPopUp = currentPopUp;
    }

    /**
     * Shows given pop-up instance and hides current pop-up if any
     */
    public void showPopUp(@NotNull PopUp popUp) {
        if (currentPopUp != null) {
            hidePopUp();
        }

        popUp.onShow();
        popUp.getPopUpStage().show();
        PopUpBuilder.alignPopUp(popUp.getPopUpStage());
        setCurrentPopUp(popUp);
    }

    /**
     * Hides currently shown pop-up if any
     */
    public void hidePopUp() {
        if (currentPopUp == null) {
            return;
        }

        currentPopUp.onHide();
        currentPopUp.getPopUpStage().hide();
        setCurrentPopUp(null);
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
}
