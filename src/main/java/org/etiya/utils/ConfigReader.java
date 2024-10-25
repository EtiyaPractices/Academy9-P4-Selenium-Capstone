package org.etiya.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//This class reads properties from a configuration file like config.properties (e.g., URL, browser type):
public class ConfigReader {
    private static Properties properties;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}

