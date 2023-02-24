package tests.smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;
import utils.GlobalFields;
import utils.GlobalValues;
import utils.Randomizer;
import utils.ThreadSleeper;

import java.time.Duration;

public class RegisterUser {
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

    @Test(groups = {"smoke","register_user"})
    public static void loginUser() {
        dismissButton();
        enterDetailsAndRegister();
    }

    public static void dismissButton() {
        driver.findElement(GlobalFields.dismissButton).click();
        ThreadSleeper.sleepSeconds(1);
    }
    public static void enterDetailsAndRegister() {
        driver.findElement(By.linkText("My Account")).click();
        ThreadSleeper.sleepSeconds(2);
        final WebElement usernameField = driver.findElement(By.id("reg_username"));
        usernameField.sendKeys(Randomizer.randomName(), Randomizer.randomLastName());
        final WebElement emailField = driver.findElement(By.id("reg_email"));
        emailField.sendKeys(Randomizer.randomEmailAddress());
        ThreadSleeper.sleepSeconds(1);
        final WebElement passwordField = driver.findElement(By.id("reg_password"));
        passwordField.sendKeys(Randomizer.randomPassword());
        driver.findElement(GlobalFields.registerButton).click();
        ThreadSleeper.sleepSeconds(2);
        Assert.assertEquals(driver.getCurrentUrl(), GlobalValues.afterLoginAndRegisterUrl);
    }
}
