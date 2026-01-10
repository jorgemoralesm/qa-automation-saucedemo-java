package com.example.qa.core;

import com.example.qa.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver createDriver() {
        // Para el proyecto junior: Chrome only (simple). Luego añadimos Firefox si quieres.
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        if (Config.headless()) {
            options.addArguments("--headless=new");
            // Recomendados para CI/Linux
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        options.addArguments("--window-size=1280,800");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
    }
}
