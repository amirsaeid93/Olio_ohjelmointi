package controller;

import dao.CurrencyDao;
import entity.Currency;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CurrencyController {

    private final CurrencyDao currencyDao = new CurrencyDao();

    public double convert(String fromCurrencyAbbr, String toCurrencyAbbr, double amount) throws SQLException, IllegalArgumentException {
        Currency fromCurrency = currencyDao.getCurrency(fromCurrencyAbbr);
        Currency toCurrency = currencyDao.getCurrency(toCurrencyAbbr);

        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("One or both currencies not found in the database.");
        }


        double amountInUSD = amount / fromCurrency.getRate();
        return amountInUSD * toCurrency.getRate();
    }

    public List<String> getAllCurrencyAbbreviations() throws SQLException {
        return currencyDao.getAllCurrencyAbbreviations();
    }
}