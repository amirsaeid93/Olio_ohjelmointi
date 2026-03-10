package dao;

import datasource.JpaConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Currency;

import java.util.List;

public class CurrencyDao {

    public void addCurrency(Currency currency) {
        EntityManager em = JpaConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
        em.close();
    }

    public Currency findCurrency(String abbreviation) {
        EntityManager em = JpaConnection.getEntityManager();
        Currency currency = em.find(Currency.class, abbreviation);
        em.close();
        return currency;
    }

    public List<Currency> getAllCurrencies() {
        EntityManager em = JpaConnection.getEntityManager();
        TypedQuery<Currency> query = em.createQuery("SELECT c FROM Currency c", Currency.class);
        List<Currency> currencies = query.getResultList();
        em.close();
        return currencies;
    }

    public void populateDatabase() {
        // Checks if currencies already exist
        if (getAllCurrencies().isEmpty()) {
            addCurrency(new Currency("USD", "US Dollar", 1.0));
            addCurrency(new Currency("EUR", "Euro", 0.92));
            addCurrency(new Currency("GBP", "British Pound", 0.79));
            addCurrency(new Currency("JPY", "Japanese Yen", 157.0));
        }
    }
}