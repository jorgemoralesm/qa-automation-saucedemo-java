package com.example.qa.tests;

import com.example.qa.config.Config;
import com.example.qa.core.DriverFactory;
import com.example.qa.pages.CartPage;
import com.example.qa.pages.CheckoutPage;
import com.example.qa.pages.InventoryPage;
import com.example.qa.pages.LoginPage;
import com.example.qa.testdata.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CheckoutTests {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createDriver();
        new LoginPage(driver)
                .open(Config.baseUrl())
                .login(Users.STANDARD_USER, Users.PASSWORD);

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();
        inventory.goToCart();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    void checkout_complete_ok() {
        CartPage cart = new CartPage(driver);
        cart.checkout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillYourInformation("Ana", "QA", "28001");
        checkout.continueCheckout();
        checkout.finish();

        assertTrue(checkout.completeMessage().toUpperCase().contains("THANK YOU"), "Should complete order");
    }

    @Test
    void checkout_fails_when_missing_postal_code() {
        CartPage cart = new CartPage(driver);
        cart.checkout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillYourInformation("Ana", "QA", "");
        checkout.continueCheckout();

        assertTrue(checkout.errorMessage().toLowerCase().contains("postal code"));
    }
}
