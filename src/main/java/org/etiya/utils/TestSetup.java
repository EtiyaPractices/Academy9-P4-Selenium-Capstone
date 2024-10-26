package org.etiya.utils;

public class TestSetup {
    public static void initialize(){
        ConfigReader.loadProperties("config.properties");
        ConfigReader.loadProperties("login.properties");
        ConfigReader.loadProperties("customerCreate.properties");
        ConfigReader.loadProperties("customerSearch.properties");
    }
}
