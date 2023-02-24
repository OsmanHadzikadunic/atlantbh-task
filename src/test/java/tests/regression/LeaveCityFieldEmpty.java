package tests.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
import java.util.Objects;

public class LeaveCityFieldEmpty {
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

    @Test(groups = {"regression","empty_city_field"})
    public static void buyMultipleProducts() {
        openProduct();
        productOptions();
        viewCartAndProceed();
        enterDetailsWhileLeavingCityFieldEmpty();
    }

    public static void openProduct() {
        ThreadSleeper.sleepSeconds(2);
        driver.get(GlobalValues.regressionProduct);
        ThreadSleeper.sleepSeconds(2);
    }
    public static void productOptions() {
        final WebElement colorDropdown = driver.findElement(GlobalFields.colorDropdown);
        Select dropDownColor = new Select(colorDropdown);
        dropDownColor.selectByVisibleText("Black");
        ThreadSleeper.sleepSeconds(1);
        final WebElement sizeDropdown = driver.findElement(GlobalFields.sizeDropdown);
        Select dropDownSize = new Select(sizeDropdown);
        dropDownSize.selectByVisibleText("Medium");
        ThreadSleeper.sleepSeconds(1);
        driver.findElement(GlobalFields.productCart).click();
        ThreadSleeper.sleepSeconds(2);
    }

    public static void viewCartAndProceed() {
        driver.findElement(GlobalFields.viewCart).click();
        ThreadSleeper.sleepSeconds(2);
        Assert.assertEquals(driver.getCurrentUrl(), GlobalValues.cartPage);
        driver.findElement(GlobalFields.proceedToCheckout).click();
        ThreadSleeper.sleepSeconds(2);
    }
    public static void enterDetailsWhileLeavingCityFieldEmpty() {
        final WebElement firstNameField = driver.findElement(GlobalFields.firstNameField);
        firstNameField.sendKeys(Randomizer.randomName());
        ThreadSleeper.sleepSeconds(2);

        final WebElement lastNameField = driver.findElement(GlobalFields.lastNameField);
        lastNameField.sendKeys(Randomizer.randomName());
        ThreadSleeper.sleepSeconds(2);

        final WebElement dropdown = driver.findElement(GlobalFields.countryField);
        dropdown.click();
        final WebElement searchBar = driver.findElement(GlobalFields.countrySearchField);
        searchBar.sendKeys("Bosnia and Herzegovina");
        searchBar.sendKeys(Keys.ENTER);

        final WebElement streetAddressField = driver.findElement(GlobalFields.streetAddressField);
        streetAddressField.sendKeys(Randomizer.randomAddress());
        ThreadSleeper.sleepSeconds(1);

        final WebElement zipCodeField = driver.findElement(GlobalFields.zipCodeField);
        zipCodeField.sendKeys(Randomizer.randomZipcode());
        ThreadSleeper.sleepSeconds(1);

        final WebElement phoneNumberField = driver.findElement(GlobalFields.phoneNumberField);
        phoneNumberField.sendKeys(Randomizer.randomPhoneNumber());
        ThreadSleeper.sleepSeconds(1);

        final WebElement emailField = driver.findElement(GlobalFields.emailField);
        emailField.sendKeys(Randomizer.randomEmailAddress());
        ThreadSleeper.sleepSeconds(1);

        Assert.assertEquals(driver.getCurrentUrl(), GlobalValues.checkoutPage);

        driver.findElement(By.id("terms")).click();
        ThreadSleeper.sleepSeconds(2);
        driver.findElement(GlobalFields.placeOrderBtn).click();
        ThreadSleeper.sleepSeconds(3);

        if (Objects.equals(driver.getTitle(), GlobalValues.checkoutTitle)) {
            System.out.println("Test Failed");
        } else {
            System.out.println("Test Passed");
        }

    }
}
