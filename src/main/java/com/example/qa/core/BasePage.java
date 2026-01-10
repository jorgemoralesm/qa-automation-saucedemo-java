package com.example.qa.core;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected final WebDriver driver;
    private final Duration timeout = Duration.ofSeconds(10);

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement $(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        waitClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement el = waitVisible(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected String text(By locator) {
        return waitVisible(locator).getText();
    }

    protected WebElement waitVisible(By locator) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitClickable(By locator) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean waitPresent(By locator) {
        try {
            new WebDriverWait(driver, timeout)
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void waitUrlContains(String fragment) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.urlContains(fragment));
    }
}
