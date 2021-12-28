package en.fluffyBerserk.base;

import en.fluffyBerserk.persistence.InsertTask;
import en.fluffyBerserk.persistence.models.User;
import javafx.stage.Stage;
import en.fluffyBerserk.base.Application;

public final class Main extends javafx.application.Application {

    // Static reference to application instance
    // so all classes don't have to pass ref
    // over and over
    public static Application app;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        User user = new User();
        user.setUsername("Marek");
        user.setPassword("Marek");
        user.setIsAdmin((byte) 0);

        user = new InsertTask<User>().insert(user);

        if (user == null) {
            System.out.println("Failed");
        } else {
            System.out.println("Success!" + user.getId());
        }
    }
}
