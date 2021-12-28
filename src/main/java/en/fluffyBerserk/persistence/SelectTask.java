package en.fluffyBerserk.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

/**
 * Class used for performing select tasks to DB layer
 *
 * @param <T>
 */
public class SelectTask<T> {

    /**
     * Performs a select query to the DB layer and returns the
     * single result, null otherwise
     *
     * @param builder lambda which builds the named query
     */
    public T singleNamedQuery(SelectTaskQuery<T> builder) {
        EntityManagerFactory factory = en.fluffyBerserk.persistence.EntityManagerFactory.getFactory();
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        T result = null;
        try {
            transaction.begin();
            try {
                result = builder.getQuery(manager).getSingleResult();
            } catch (NoResultException e) {
                // no need to do anything, result is null at this point
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Single select task failed with exception: " + e);
            return null;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }

        return result;
    }
}
