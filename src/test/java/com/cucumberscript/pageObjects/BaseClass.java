package com.cucumberscript.pageObjects;

import com.cucumberscript.utilities.Propertyutils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

import static com.cucumberscript.utilities.GetBrowserDriver.getBrowserDetails;

public class BaseClass {
    public static WebDriver driver;
    static Properties properties; // this is to load application.properties

    static {
        try {
            properties = Propertyutils.loadApplicationProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Properties props; // this is to load framework.properties

    static {
        try {
            props = Propertyutils.loadFrameworkProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initializationDriver() {
        String baseUrl = properties.getProperty("application.url"); //this is to get value from the key(each prsoperty)
        String browser = props.getProperty("browser.driver");
        driver = getBrowserDetails(browser);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }


    public static void closeDriver() {
        driver.quit();
    }
    //WebdriverManager= WebDriverManager is an open-source library created by Boni García
    // that automates the management (downloading, setting up, and updating) of browser drivers required by Selenium

}
