package org.etiya.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//This class reads properties from a configuration file like config.properties (e.g., URL, browser type):
public class ConfigReader {
    private static Properties properties;

    public static void loadProperties(String fileName) {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/java/org/etiya/resources/"+ fileName);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}

