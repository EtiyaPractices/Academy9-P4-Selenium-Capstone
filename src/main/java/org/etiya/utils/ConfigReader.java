package org.etiya.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//This class reads properties from a configuration file like config.properties (e.g., URL, browser type):
public class ConfigReader {
    private static Map<String, Properties> propertiesMap = new HashMap<>();

    public static void loadProperties(String fileName) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/java/org/etiya/resources/"+ fileName);
            properties.load(fileInputStream);
            propertiesMap.put(fileName, properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String fileName,String key){
        Properties properties = propertiesMap.get(fileName);
        if(properties != null){
            return properties.getProperty(key);
        } else{
            throw new RuntimeException("Properties file " + fileName + " not loaded.");
        }
    }
}

