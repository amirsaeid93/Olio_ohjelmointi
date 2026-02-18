package model;
import java.util.HashMap;
import java.util.Map;

public class CurrencyModel {
    private final Map<String, Double> currencyRates;

    public CurrencyModel() {
        currencyRates = new HashMap<>();

        currencyRates.put("USD", 1.0);
        currencyRates.put("EUR", 0.85);
        currencyRates.put("GBP", 0.75);
        currencyRates.put("JPY", 110.0);
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        if (!currencyRates.containsKey(fromCurrency) || !currencyRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency");
        }
        double fromRate = currencyRates.get(fromCurrency);
        double toRate = currencyRates.get(toCurrency);
        return (amount / fromRate) * toRate;
    }

    public Map<String, Double> getCurrencyRates() {
        return currencyRates;
    }
}