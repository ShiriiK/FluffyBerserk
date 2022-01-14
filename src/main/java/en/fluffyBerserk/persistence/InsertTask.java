package en.fluffyBerserk.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Class used for performing insert tasks to DB layer
 *
 * @param <T>
 */
public class InsertTask<T> {

    /**
     * Performs an insert query into the DB layer and returns the
     * inserted result, null otherwise
     *
     * @param object object to be inserted
     */
    public T insert(final T object) {
        EntityManager manager = DatabaseSession.getSession();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(object);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Insert task failed with exception: " + e);
            return null;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }

        return object;
    }
}
