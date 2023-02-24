package utils;

import org.openqa.selenium.By;

public class GlobalFields {
    public static By productCart = By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/div/div[2]/button");
    public static By colorDropdown = By.id("pa_color");
    public static By sizeDropdown = By.id("pa_size");
    public static By colorDropdownDress = By.id("color");
    public static By sizeDropdownDress = By.id("size");
    public static By quantityIncrease = By.className("qty-increase");
    public static By viewCart = By.className("wp-element-button");
    public static By proceedToCheckout = By.linkText("PROCEED TO CHECKOUT");
    public static By firstNameField = By.id("billing_first_name");
    public static By lastNameField = By.id("billing_last_name");
    public static By countryField = By.id("select2-billing_country-container");
    public static By countrySearchField = By.className("select2-search__field");
    public static By streetAddressField = By.id("billing_address_1");
    public static By zipCodeField = By.id("billing_postcode");
    public static By cityField = By.id("billing_city");
    public static By phoneNumberField = By.id("billing_phone");
    public static By emailField = By.id("billing_email");
    public static By placeOrderBtn = By.id("place_order");
    public static By searchBarOpener = By.className("noo-search");
    public static By searchProduct = By.className("form-control");
    public static By removeProductFromCart = By.cssSelector("#post-6 > div > div > form > table > tbody > tr.cart_item > td.product-remove > a");
    public static By emailContact = By.cssSelector("#noo-site > header > div.noo-topbar > div > ul.pull-left.noo-topbar-left > li:nth-child(1) > a");
    public static By phoneNumberContact = By.cssSelector("#noo-site > header > div.noo-topbar > div > ul.pull-left.noo-topbar-left > li:nth-child(2) > a");
    public static By dismissButton = By.className("woocommerce-store-notice__dismiss-link");
    public static By loginSubmitButton = By.cssSelector("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > button");
    public static By registerButton = By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(5) > button");
}
