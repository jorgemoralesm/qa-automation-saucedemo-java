package com.example.qa.pages;

import com.example.qa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By finishBtn = By.id("finish");
    private final By completeHeader = By.className("complete-header");
    private final By error = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillYourInformation(String fn, String ln, String pc) {
        type(firstName, fn);
        type(lastName, ln);
        type(postalCode, pc);
    }

    public void continueCheckout() {
        click(continueBtn);
    }

    public void finish() {
        click(finishBtn);
    }

    public String completeMessage() {
        return driver.findElements(completeHeader).isEmpty() ? "" : text(completeHeader);
    }

    public String errorMessage() {
        return driver.findElements(error).isEmpty() ? "" : text(error);
    }
}
