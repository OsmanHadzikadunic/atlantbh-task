package tests.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;
import utils.GlobalFields;
import utils.GlobalValues;
import utils.QuantityIncreaseButton;
import utils.Randomizer;
import utils.ThreadSleeper;

import java.time.Duration;

public class BuyProductMoreQuantity {

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


    @Test(groups = {"regression","buy_products_more_quantity"})
    public static void buyProducts() {
        openProduct();
        productOptions();
        viewCartAndProceed();
        enterDetailsAndPurchase();
    }
        public static void openProduct() {
            ThreadSleeper.sleepSeconds(2);
            driver.get(GlobalValues.openProduct);
            ThreadSleeper.sleepSeconds(2);
    }
        public static void productOptions() {
            final WebElement colorDropdown = driver.findElement(GlobalFields.colorDropdown);
            Select dropDownColor = new Select(colorDropdown);
            dropDownColor.selectByVisibleText("Pink");
            ThreadSleeper.sleepSeconds(1);
            final WebElement sizeDropdown = driver.findElement(GlobalFields.sizeDropdown);
            Select dropDownSize = new Select(sizeDropdown);
            dropDownSize.selectByVisibleText("38");
            ThreadSleeper.sleepSeconds(1);
            final WebElement quantityButton = driver.findElement(GlobalFields.quantityIncrease);
            QuantityIncreaseButton.clickNTimes(quantityButton, 4);
            ThreadSleeper.sleepSeconds(2);
            driver.findElement(GlobalFields.productCart).click();
            ThreadSleeper.sleepSeconds(2);
        }
        public static void viewCartAndProceed() {
            driver.findElement(GlobalFields.viewCart).click();
            ThreadSleeper.sleepSeconds(2);
            driver.findElement(GlobalFields.proceedToCheckout).click();
            ThreadSleeper.sleepSeconds(2);
        }

        public static void enterDetailsAndPurchase() {

            final WebElement firstNameField = driver.findElement(GlobalFields.firstNameField);
            firstNameField.sendKeys(Randomizer.randomName());
            ThreadSleeper.sleepSeconds(2);

            final WebElement lastNameField = driver.findElement(GlobalFields.lastNameField);
            lastNameField.sendKeys(Randomizer.randomLastName());
            ThreadSleeper.sleepSeconds(2);

            final WebElement dropdown = driver.findElement(GlobalFields.countryField);
            dropdown.click();
            WebElement searchBar = driver.findElement(GlobalFields.countrySearchField);
            searchBar.sendKeys("Bosnia and Herzegovina");
            searchBar.sendKeys(Keys.ENTER);

            final WebElement streetAddressField = driver.findElement(GlobalFields.streetAddressField);
            streetAddressField.sendKeys(Randomizer.randomAddress());
            ThreadSleeper.sleepSeconds(1);

            final WebElement zipCodeField = driver.findElement(GlobalFields.zipCodeField);
            zipCodeField.sendKeys(Randomizer.randomZipcode());
            ThreadSleeper.sleepSeconds(1);

            final WebElement cityField = driver.findElement(GlobalFields.cityField);
            cityField.sendKeys(Randomizer.randomCity());
            ThreadSleeper.sleepSeconds(1);

            final WebElement phoneNumberField = driver.findElement(GlobalFields.phoneNumberField);
            phoneNumberField.sendKeys(Randomizer.randomPhoneNumber());
            ThreadSleeper.sleepSeconds(1);

            final WebElement emailField = driver.findElement(GlobalFields.emailField);
            emailField.sendKeys(Randomizer.randomEmailAddress());
            ThreadSleeper.sleepSeconds(1);

            driver.findElement(By.id("terms")).click();
            ThreadSleeper.sleepSeconds(2);
            driver.findElement(GlobalFields.placeOrderBtn).click();
            ThreadSleeper.sleepSeconds(3);
        }

    }
