package com.example.qa.tests;

import com.example.qa.config.Config;
import com.example.qa.core.DriverFactory;
import com.example.qa.pages.CartPage;
import com.example.qa.pages.InventoryPage;
import com.example.qa.pages.LoginPage;
import com.example.qa.testdata.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class CartTests {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createDriver();
        new LoginPage(driver)
                .open(Config.baseUrl())
                .login(Users.STANDARD_USER, Users.PASSWORD);
        assertTrue(new InventoryPage(driver).isAt());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    void add_product_to_cart() {
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();
        assertTrue(inventory.backpackAdded());

        inventory.goToCart();
        CartPage cart = new CartPage(driver);
        assertTrue(cart.hasItem("Sauce Labs Backpack"));
    }
}
