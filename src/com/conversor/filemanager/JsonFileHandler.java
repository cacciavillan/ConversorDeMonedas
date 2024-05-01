package com.conversor.filemanager;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileHandler {

    /**
     * Writes a Java Object in a Json file
     * @param filePath
     * @param data, the object to write in the file
     * @throws IOException if throws I/O error by writing the file.
     */


    public static void writeJsonToFile(String filePath, String data) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
        }
    }

    /**
     * Verifies if the JSON file exists
     * @param filePath
     * @return true if the file exists, else false
     */

    public static boolean jsonFileExists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }

    /**
     * Loads a Json file to memory
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String jsonFileLoad(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

}