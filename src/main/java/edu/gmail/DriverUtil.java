package edu.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class DriverUtil {

    private static DriverUtil driver;

    private DriverUtil() {
    }

    static WebDriver getDriver() {
        if (driver == null) {
            driver = new DriverUtil();
        }
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    }
}
