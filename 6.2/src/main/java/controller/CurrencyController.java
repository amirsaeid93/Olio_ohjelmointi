package controller;
import model.CurrencyModel;

import java.util.Map;
public class CurrencyController {
    private final CurrencyModel model;

    public CurrencyController() {
        model = new CurrencyModel();
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        return model.convert(fromCurrency, toCurrency, amount);
    }

    public Map<String, Double> getCurrencyRates() {
        return model.getCurrencyRates();
    }
}