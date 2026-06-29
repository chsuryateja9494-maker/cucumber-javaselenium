package com.cucumberscript.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetBrowserDriver {
    public static WebDriver driver;

    public static WebDriver getBrowserDetails(String browser){
        if(browser!=null){
            if(browser.equalsIgnoreCase("chrome")){
                driver = setChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = setFirefoxDriver();
            }  else{
                driver = setEdgeDriver();
            }
        }
        return driver;
    }

    public static WebDriver setChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver setFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver setEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }
}
