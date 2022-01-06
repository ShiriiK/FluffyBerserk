package en.fluffyBerserk.persistence;

import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManager;
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
    public boolean delete(@NotNull final T object) {
        EntityManager manager = DatabaseSession.getSession();
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
        }

        return true;
    }
}
