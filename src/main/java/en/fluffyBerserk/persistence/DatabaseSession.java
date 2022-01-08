package en.fluffyBerserk.persistence;

import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DatabaseSession {

    /**
     * Unit name used to load entity manager
     * Refers to a unit defined in persistence.xml
     */
    private static final String UNIT_NAME = "default";

    private static EntityManager manager = null;

    public static @NotNull EntityManager getSession() {
        if (manager == null) {
            throw new RuntimeException("Session has not been started!");
        }

        return manager;
    }

   /** public static void startSession() {
        manager = Persistence.createEntityManagerFactory(UNIT_NAME).createEntityManager();
    }*/

    public static void closeSession() {
        if (manager != null) {
            manager.getEntityManagerFactory().close();
            manager.close();
        }
    }
}
