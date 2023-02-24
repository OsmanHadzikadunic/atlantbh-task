package tests.smoke;

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
import utils.ThreadSleeper;

import java.time.Duration;
import java.util.Objects;

public class AddRemoveItemFromCart {
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

    @Test(groups = {"smoke","add_remove_item"})
    public static void addRemoveItem() {
        openFirstProduct();
        productOptionsAndAddToCart();
        viewCartAndRemoveProduct();
    }

    public static void openFirstProduct() {
        ThreadSleeper.sleepSeconds(2);
        driver.get(GlobalValues.thirdRegressionProduct);
        ThreadSleeper.sleepSeconds(2);
    }

    public static void productOptionsAndAddToCart() {
        final WebElement colorDropdown = driver.findElement(GlobalFields.colorDropdownDress);
        Assert.assertEquals(driver.getCurrentUrl(), GlobalValues.thirdRegressionProduct);
        Select dropDownColor = new Select(colorDropdown);
        dropDownColor.selectByVisibleText("White");
        ThreadSleeper.sleepSeconds(1);
        final WebElement sizeDropdown = driver.findElement(GlobalFields.sizeDropdownDress);
        Select dropDownSize = new Select(sizeDropdown);
        dropDownSize.selectByVisibleText("M");
        ThreadSleeper.sleepSeconds(1);
        driver.findElement(GlobalFields.productCart).click();
        ThreadSleeper.sleepSeconds(2);
    }

    public static void viewCartAndRemoveProduct() {
        driver.findElement(GlobalFields.viewCart).click();
        ThreadSleeper.sleepSeconds(2);
        Assert.assertEquals(driver.getCurrentUrl(), GlobalValues.cartPage);
        driver.findElement(GlobalFields.removeProductFromCart).click();
        ThreadSleeper.sleepSeconds(2);
        if(Objects.equals(driver.getCurrentUrl(), GlobalValues.removedItem)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

    }


}
