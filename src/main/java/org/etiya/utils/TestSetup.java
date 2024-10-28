package org.etiya.utils;

public class TestSetup {
    public static void initialize(){
        ConfigReader.loadProperties("config.properties");
        ConfigReader.loadProperties("auth.properties");
        ConfigReader.loadProperties("customerManagement.properties");
        ConfigReader.loadProperties("saleProcessManagement.properties");
    }
}
