package datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaConnection {
    private static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            try {
                emf = Persistence.createEntityManagerFactory("CurrencyPU");
            } catch (Exception e) {
                System.err.println("Error creating EntityManagerFactory: " + e.getMessage());
                throw new RuntimeException("Failed to initialize JPA connection.", e);
            }
        }
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}