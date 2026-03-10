package dao;

import datasource.JpaConnection;
import jakarta.persistence.EntityManager;
import model.Transaction;

public class TransactionDao {

    public void saveTransaction(Transaction transaction) {
        EntityManager em = JpaConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(transaction);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Re-throws to be handled by the controller/view
        } finally {
            em.close();
        }
    }
}