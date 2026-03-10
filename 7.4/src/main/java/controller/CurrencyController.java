package controller;

import dao.CurrencyDao;
import dao.TransactionDao;
import model.Currency;
import model.Transaction;

import java.util.List;

public class CurrencyController {

    private final CurrencyDao currencyDao = new CurrencyDao();
    private final TransactionDao transactionDao = new TransactionDao();

    public void initializeDatabase() {
        currencyDao.populateDatabase();
    }

    public List<Currency> getCurrencies() {
        return currencyDao.getAllCurrencies();
    }

    public double convertAndSave(String fromAbbr, String toAbbr, double amount) {
        Currency fromCurrency = currencyDao.findCurrency(fromAbbr);
        Currency toCurrency = currencyDao.findCurrency(toAbbr);

        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Invalid currency selection.");
        }

        // Performs conversions
        double amountInBase = amount / fromCurrency.getRate();
        double convertedAmount = amountInBase * toCurrency.getRate();

        // Creates and saves transactions
        Transaction transaction = new Transaction(fromCurrency, toCurrency, amount, convertedAmount);
        transactionDao.saveTransaction(transaction);

        return convertedAmount;
    }
}