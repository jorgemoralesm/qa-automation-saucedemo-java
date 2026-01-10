package com.example.qa.pages;

import com.example.qa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By checkoutBtn = By.id("checkout");
    private final By itemNames = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasItem(String name) {
        return driver.findElements(itemNames).stream()
                .anyMatch(e -> e.getText().equalsIgnoreCase(name));
    }

    public void checkout() {
        click(checkoutBtn);
    }

}
