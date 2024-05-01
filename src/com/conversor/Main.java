package com.conversor;

import com.conversor.ui.UserConsole;
import com.conversor.datamanager.DataSyncManager;


public class Main {
    public static void main(String[] args) {
        String filePath = "json_file/response.json";
        DataSyncManager dataSyncManager = new DataSyncManager(filePath);
        UserConsole userConsole = new UserConsole();

        dataSyncManager.ensureDataIsFresh();

        userConsole.start();



    }
}
