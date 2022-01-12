package en.fluffyBerserk.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Class used for performing update tasks to DB layer
 *
 * @param <T>
 */
public class UpdateTask<T> {

    /**
     * Performs an update query into the DB layer and returns result
     *
     * @param object object to be updated
     */
    public boolean update(final T object) {
        EntityManager manager = DatabaseSession.getSession();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.merge(object);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Update task failed with exception: " + e);
            return false;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }

        return true;
    }
}
