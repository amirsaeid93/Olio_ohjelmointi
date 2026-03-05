package controller;

import dao.CurrencyDao;
import entity.Currency;

import java.util.Collections;
import java.util.List;

public class CurrencyController {

    private final CurrencyDao currencyDao = new CurrencyDao();

    public double convert(String fromCurrencyAbbr, String toCurrencyAbbr, double amount) throws IllegalArgumentException, RuntimeException {
        Currency fromCurrency = currencyDao.getCurrency(fromCurrencyAbbr);
        Currency toCurrency = currencyDao.getCurrency(toCurrencyAbbr);

        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("One or both currencies not found.");
        }


        double amountInBase = amount / fromCurrency.getRate();
        return amountInBase * toCurrency.getRate();
    }

    public List<String> getAllCurrencyAbbreviations() throws RuntimeException {
        try {
            return currencyDao.getAllCurrencyAbbreviations();
        } catch (Exception e) {

            throw new RuntimeException("Failed to retrieve currency abbreviations from database.", e);
        }
    }

    public void addCurrency(String abbreviation, String name, double rate) throws IllegalArgumentException, RuntimeException {
        if (abbreviation == null || abbreviation.trim().isEmpty() || name == null || name.trim().isEmpty() || rate <= 0) {
            throw new IllegalArgumentException("Invalid currency data provided.");
        }
        if (currencyDao.getCurrency(abbreviation) != null) {
            throw new IllegalArgumentException("Currency with this abbreviation already exists.");
        }
        Currency newCurrency = new Currency(abbreviation.toUpperCase(), name, rate);
        try {
            currencyDao.addCurrency(newCurrency);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add new currency to database.", e);
        }
    }
}