package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CartPage {
    private AndroidDriver driver;

    private By addToCart = By.xpath("//*[@content-desc='test-ADD TO CART']");
    private By cartButton = By.xpath("//android.widget.TextView[@text=\"CHECKOUT\"]");

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        System.out.println("Added successfully in cart screen and Checkout screen gone");
    }

    public void addItemToCart() {
        driver.findElement(addToCart).click();
        driver.findElement(cartButton).click();
    }
}
