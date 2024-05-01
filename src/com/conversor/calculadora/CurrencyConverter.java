package com.conversor.calculadora;

public class CurrencyConverter {
    private RateManager rateManager;

    public CurrencyConverter() {
        rateManager = new RateManager();
    }

    public double convert(Double amount, String fromCurrency, String toCurrency) {
        Double rateFrom = rateManager.getrates_left(fromCurrency);
        Double rateTo = rateManager.getrates_left(toCurrency);
        return (rateTo / rateFrom) * amount;
    }
}
