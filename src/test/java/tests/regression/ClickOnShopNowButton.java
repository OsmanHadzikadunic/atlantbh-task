package tests.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;
import utils.GlobalFields;
import utils.GlobalValues;
import utils.ThreadSleeper;

import java.time.Duration;
import java.util.Objects;

public class ClickOnShopNowButton {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void driverInit() {
        driver = Driver.driverInit();
        ThreadSleeper.sleepSeconds(2);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }


    @Test(groups = {"regression","shopNow_button"})
    public static void scrollAndClickButtonTest() {
        scrollAndClickButton();

    }

    public static void scrollAndClickButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)", "");
        ThreadSleeper.sleepSeconds(3);
        driver.findElement(By.cssSelector(".right span")).click();
        ThreadSleeper.sleepSeconds(2);
        if (Objects.equals(driver.getCurrentUrl(), GlobalValues.baseurl)) {
            System.out.println("Test Failed");
        } else {
            System.out.println("Test Passed");
        }
    }
}
