package dao;

import datasource.JpaConnection;
import entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.stream.Collectors;

public class CurrencyDao {

    public Currency getCurrency(String abbreviation) {
        EntityManager em = JpaConnection.getEntityManager();
        try {
            return em.find(Currency.class, abbreviation);
        } finally {
            em.close();
        }
    }

    public List<String> getAllCurrencyAbbreviations() {
        EntityManager em = JpaConnection.getEntityManager();
        try {
            TypedQuery<String> query = em.createQuery("SELECT c.abbreviation FROM Currency c ORDER BY c.abbreviation", String.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Currency> getAllCurrencies() {
        EntityManager em = JpaConnection.getEntityManager();
        try {
            TypedQuery<Currency> query = em.createQuery("SELECT c FROM Currency c ORDER BY c.abbreviation", Currency.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void addCurrency(Currency currency) {
        EntityManager em = JpaConnection.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(currency);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}