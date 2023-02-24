package utils;

import org.openqa.selenium.WebElement;

public class QuantityIncreaseButton {
    public static void clickNTimes(WebElement element, int n) {
        for (int i = 0; i < n; i++) {
            element.click();
        }
    }
}
