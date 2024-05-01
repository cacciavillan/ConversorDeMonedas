package com.conversor.datamanager;

import com.conversor.filemanager.JsonFileHandler;

import com.conversor.network.HttpService;

import java.io.IOException;

public class DataSyncManager {
    private final String dataFilePath;
    private final HttpService httpService;

    public DataSyncManager(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.httpService = new HttpService();
    }

    public void loadDataInCache(String dataFilePath) {
        try {
            System.out.println("Actualizando desde Json");
            String json = JsonFileHandler.jsonFileLoad(dataFilePath);
            DataRateCache.getInstance().updateFromJson(json);
        } catch (IOException e) {
            System.out.println("Actualizando Datos...");;
        }
    }


    public void ensureDataIsFresh() {
        loadDataInCache(dataFilePath);
        try {
            if (needsUpdate()) {
                System.out.println("Updating Currencies...");
                String jsonData = String.valueOf(fetchDataFromRemote());
                updateLocalData(jsonData);
                updateCache(jsonData);
            } else {
                System.out.println("Data is up to date");
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }


    public boolean needsUpdate() {
        long currentTime = System.currentTimeMillis() / 1000;
        long nextUpdateTime = DataRateCache.getInstance().getTime_next_update_unix();
        boolean fileExists = JsonFileHandler.jsonFileExists(dataFilePath);
        boolean cacheIsUpdated = currentTime < nextUpdateTime;
        System.out.println(String.format("File Exists: %b && Cache is updated: %b", fileExists, cacheIsUpdated));
        return !fileExists || !cacheIsUpdated;
    }

    private String fetchDataFromRemote() throws Exception {
        return httpService.fetchJsonData("https://v6.exchangerate-api.com/v6/8465359b8ea86c6f37f36824/latest/USD");
    }

    private void updateLocalData(String jsonData) {
        try {
            JsonFileHandler.writeJsonToFile(dataFilePath, jsonData);
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo: " + e.getMessage());
        }
    }

    private void updateCache(String jsonData) {
        DataRateCache.getInstance().updateFromJson(jsonData);
    }
}
