package en.fluffyBerserk.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
     * @param object object to be inserted
     * @return T
     */
    public T insert(T object) {
        EntityManagerFactory factory = en.fluffyBerserk.persistence.EntityManagerFactory.getFactory();
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(object);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Persistent task failed with given message: " + e.getMessage());
            return null;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }

        return object;
    }
}
