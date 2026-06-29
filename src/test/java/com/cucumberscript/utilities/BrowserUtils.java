package com.cucumberscript.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

import static com.cucumberscript.pageObjects.BaseClass.driver;

public class BrowserUtils {
    Actions action  = new Actions(driver);

    public WebElement waitForWebElement(WebElement element) {
        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500))
                .ignoreAll(List.of(NoSuchElementException.class, StaleElementReferenceException.class))
                .until(d -> element.isDisplayed() ? element : null);
    }

    public void hoverAndClick(WebElement e1, WebElement e2) {
        action.moveToElement(e1).click(e2).build().perform();
    }

    public void clickElementByText(String elementText){
        waitForWebElement(driver.findElement(By.xpath("//*[text()='"+elementText+"']")));
        action.moveToElement(driver.findElement(By.xpath("//*[text()='"+elementText+"']"))).click().build().perform();
    }

}
