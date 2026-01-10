package com.example.qa.config;

public class Config {
    public static String baseUrl() {
        String v = System.getProperty("baseUrl");
        return (v == null || v.isBlank()) ? "https://www.saucedemo.com" : v;
    }

    public static String browser() {
        String v = System.getProperty("browser");
        return (v == null || v.isBlank()) ? "chrome" : v;
    }

    public static boolean headless() {
        String v = System.getProperty("headless");
        return v != null && v.equalsIgnoreCase("true");
    }
}
