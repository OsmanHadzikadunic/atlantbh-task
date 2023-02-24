package tests.smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;
import utils.GlobalFields;
import utils.ThreadSleeper;

import java.time.Duration;

public class ContactEmailInformation {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void driverInit(){
        driver = Driver.driverInit();
        ThreadSleeper.sleepSeconds(2);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver(){
        driver.quit();
    }

    @Test(groups = {"smoke","email_contact"})
    public static void clickOnEmailContact() {
        dismissButton();
        checkOnEmailContactVisibility();
    }

    public static void dismissButton() {
        driver.findElement(GlobalFields.dismissButton).click();
        ThreadSleeper.sleepSeconds(1);
    }

    public static void checkOnEmailContactVisibility() {
        final WebElement emailContact = driver.findElement(GlobalFields.emailContact);
        if (emailContact.isDisplayed()) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        emailContact.click();
        ThreadSleeper.sleepSeconds(2);
    }
}
