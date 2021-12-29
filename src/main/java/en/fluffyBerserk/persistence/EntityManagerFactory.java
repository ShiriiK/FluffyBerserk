package en.fluffyBerserk.persistence;

import javax.persistence.Persistence;

public class EntityManagerFactory {

    /**
     * Unit name used to load entity manager
     * Refers to a unit defined in persistence.xml
     */
    private static final String UNIT_NAME = "default";

    public static javax.persistence.EntityManagerFactory getFactory() {
        return Persistence.createEntityManagerFactory(UNIT_NAME);
    }
}
