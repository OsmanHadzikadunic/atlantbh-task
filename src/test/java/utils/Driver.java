package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static WebDriver driverInit(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        final WebDriver driver = new ChromeDriver();
        driver.get(GlobalValues.baseurl);
        return driver;
    }
}
