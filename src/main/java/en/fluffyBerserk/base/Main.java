package en.fluffyBerserk.base;

import en.fluffyBerserk.persistence.SelectTask;
import en.fluffyBerserk.persistence.models.User;
import javafx.stage.Stage;
import en.fluffyBerserk.base.Application;

import javax.persistence.TypedQuery;

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
        User user = new SelectTask<User>().singleNamedQuery(manager -> {
            TypedQuery<User> query = manager.createNamedQuery("User.byId", User.class);
            query.setParameter(1, (long) 5);
            return query;
        });

        if (user == null) {
            System.out.println("Failed");
        } else {
            System.out.println("Success!" + user.getId());
        }
    }
}
