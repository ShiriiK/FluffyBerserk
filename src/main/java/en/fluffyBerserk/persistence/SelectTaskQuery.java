package en.fluffyBerserk.persistence;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public interface SelectTaskQuery<T> {

    /**
     * Builds named query for specific generic type
     */
    TypedQuery<T> getQuery(final EntityManager manager);
}
