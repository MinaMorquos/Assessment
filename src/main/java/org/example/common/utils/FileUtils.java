package org.example.common.utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class FileUtils {
    String directoryName = "Script Files";
    public void writeKeyAndValueInFile(String fileName,Map<String, String> data){
        File directory = new File(directoryName);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory created successfully.");
            } else {
                System.out.println("Failed to create directory.");
                return;
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(directoryName+"/"+fileName), data);
        } catch (IOException e) {
            throw new Error(e);
        }
    }
    public int readValueBasedOnKey(String key,String fileName){
        String value;
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(directoryName+"/"+fileName)));
            JSONObject jsonObject = new JSONObject(jsonContent);
             value = jsonObject.getString(key);
        } catch (IOException e) {
            throw new Error (e);
        }
        return Integer.parseInt(value);
    }
}
