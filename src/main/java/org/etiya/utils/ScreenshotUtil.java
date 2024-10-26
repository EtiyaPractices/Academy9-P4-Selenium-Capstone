package org.etiya.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static void takeScreenshot(String fileName){
        WebDriver driver = Driver.getDriver();
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = Constants.SCREENSHOTS_PATH + fileName +"-" + timestamp + ".png";

        try{
            FileUtils.copyFile(srcFile, new File(filePath));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
