package com.cucumberscript.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class BrowserUtils {
    WebDriver driver;

    public WebElement waitForWebElement(WebElement element){
        return new FluentWait<>(this.driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500))
                .ignoreAll(List.of(NoSuchElementException.class, StaleElementReferenceException.class))
                .until(d -> element.isDisplayed() ? element : null);
        }



    }
