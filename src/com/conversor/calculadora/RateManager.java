package com.conversor.calculadora;

import com.conversor.datamanager.DataRateCache;

import java.util.Map;

public class RateManager {

    DataRateCache cache = DataRateCache.getInstance();

    public double getrates_left(String left) {
        Map<String, Double> rates = cache.getConversion_rates();

        if (rates != null && rates.containsKey(left)) {
            return rates.get(left);
        } else {
            throw new IllegalStateException("The currency rate is not available: " + left);
        }
    }

}
