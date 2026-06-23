package com.cucumberscript.pageObjects;

import com.cucumberscript.utilities.Propertyutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static void initializationDriver() throws IOException {
        Properties props = Propertyutils.loadApplicationProperties(); // this is to load application.properties
        String baseUrl = props.getProperty("application.url"); //this is to get value from the key(each prsoperty)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }


    public static void closeDriver() {
        driver.quit();
    }

    //WebdriverManager= WebDriverManager is an open-source library created by Boni García
    // that automates the management (downloading, setting up, and updating) of browser drivers required by Selenium

}
