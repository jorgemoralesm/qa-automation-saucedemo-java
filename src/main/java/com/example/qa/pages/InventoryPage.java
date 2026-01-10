package com.example.qa.pages;

import com.example.qa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private final By title = By.className("title");
    private final By cartLink = By.className("shopping_cart_link");

    // Un producto concreto para que sea estable:
    private final By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By removeBackpack = By.id("remove-sauce-labs-backpack");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return driver.getCurrentUrl().contains("inventory") && text(title).equalsIgnoreCase("Products");
    }

    public void addBackpackToCart() {
        click(addBackpack);
    }

    public boolean backpackAdded() {
        return !driver.findElements(removeBackpack).isEmpty();
    }

    public void goToCart() {
        click(cartLink);
    }
}
