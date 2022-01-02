package en.fluffyBerserk.persistence;

import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Class used for performing delete tasks to DB layer
 *
 * @param <T>
 */
public class DeleteTask<T> {

    /**
     * Performs delete query into the DB layer and returns the
     * result
     *
     * @param object object to be deleted
     */
    public boolean delete(@NotNull T object) {
        EntityManagerFactory factory = en.fluffyBerserk.persistence.EntityManagerFactory.getFactory();
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.remove(manager.contains(object) ? object : manager.merge(object));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Delete task failed with exception: " + e);
            return false;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }

        return true;
    }
}
