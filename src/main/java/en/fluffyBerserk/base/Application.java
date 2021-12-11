package main.java.en.fluffyBerserk.base;

import javafx.stage.*;
import main.java.en.fluffyBerserk.ui.popups.PopUp;
import main.java.en.fluffyBerserk.ui.screens.DefaultScreen;
import main.java.en.fluffyBerserk.ui.screens.Screen;

public final class Application {

    private final Stage primaryStage;

    private Screen currentScreen;

    private PopUp currentPopUp;

    public Application(Stage stage) {
        primaryStage = stage;
        init();
    }

    public void init() {
        // init primary stage
        primaryStage.setTitle("Fluffy Berserk");

        primaryStage.setHeight(500.0);
        primaryStage.setWidth(500.0);

        // Set default screen
        this.changeScreen(new DefaultScreen(this));
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

        setCurrentScreen(screen);

        currentScreen.onEnter();
    }

    public void showPopUp(PopUp popUp) {

    }

    public void hidePopUp() {

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
