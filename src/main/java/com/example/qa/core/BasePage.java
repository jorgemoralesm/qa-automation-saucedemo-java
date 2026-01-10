package com.example.qa.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement $(By locator) {
        return driver.findElement(locator);
    }

    protected void type(By locator, String text) {
        WebElement el = $(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected void click(By locator) {
        $(locator).click();
    }

    protected String text(By locator) {
        return $(locator).getText();
    }
}
