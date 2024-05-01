package com.conversor.datamanager;

import com.google.gson.Gson;

import java.util.Map;

public class DataRateCache {
    private static DataRateCache instance;
    private String result;
    private long time_next_update_unix;
    private Map<String, Double> conversion_rates;

    private DataRateCache() {}

    public static DataRateCache getInstance() {
        if (instance == null) {
            instance = new DataRateCache();
        }
        return instance;
    }

    public String getResult() {
        return result;
    }

    public long getTime_next_update_unix() {
        return time_next_update_unix;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void updateFromJson(String json) {
        Gson gson = new Gson();
        DataRateCache data = gson.fromJson(json, DataRateCache.class);
        this.result = data.result;
        this.time_next_update_unix = data.time_next_update_unix;
        this.conversion_rates = data.conversion_rates;
        System.out.println("UpdateFromJson Completado");
    }
}