package tests.smoke;

import org.openqa.selenium.Keys;
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
import utils.ThreadSleeper;

import java.time.Duration;

public class SearchTest {

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

    @Test(groups = {"smoke","search_test"})
    public static void searchProduct() {
        searchNavigation();
    }

    public static void searchNavigation() {
        driver.findElement(GlobalFields.searchBarOpener).click();
        ThreadSleeper.sleepSeconds(1);
        final WebElement searchProduct = driver.findElement(GlobalFields.searchProduct);
        searchProduct.sendKeys("T-shirt");
        searchProduct.sendKeys(Keys.ENTER);
        ThreadSleeper.sleepSeconds(2);
        Assert.assertEquals(driver.getCurrentUrl(), GlobalValues.verifySearchProductPage);
        Assert.assertEquals(driver.getTitle(), GlobalValues.productTitle);
    }
}
