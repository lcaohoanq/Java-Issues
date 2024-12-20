package org.seleniumdemo.common;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class BrowserFactory {
    static WebDriver getBrowser(String browserName) {
        WebDriver driver;
        if (browserName != null && browserName.equals("chrome")) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        } else {
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}

