package com.example.qa.tests;

import com.example.qa.config.Config;
import com.example.qa.core.DriverFactory;
import com.example.qa.pages.InventoryPage;
import com.example.qa.pages.LoginPage;
import com.example.qa.testdata.Users;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LoginTests {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createDriver();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    void login_ok_standard_user() {
        LoginPage login = new LoginPage(driver).open(Config.baseUrl());
        login.login(Users.STANDARD_USER, Users.PASSWORD);

        InventoryPage inventory = new InventoryPage(driver);
        assertTrue(inventory.isAt(), "Should land on inventory page after login");
    }

    @Test
    void login_fails_with_wrong_password() {
        LoginPage login = new LoginPage(driver).open(Config.baseUrl());
        login.login(Users.STANDARD_USER, "wrong_pass");

        assertTrue(login.errorMessage().toLowerCase().contains("username and password do not match"));
    }

    @Test
    void login_fails_locked_out_user() {
        LoginPage login = new LoginPage(driver).open(Config.baseUrl());
        login.login(Users.LOCKED_OUT_USER, Users.PASSWORD);

        assertTrue(login.errorMessage().toLowerCase().contains("locked out"));
    }
}
