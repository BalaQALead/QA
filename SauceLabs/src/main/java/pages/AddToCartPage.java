package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class AddToCartPage extends BasePage {

    public AddToCartPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    private By firstProductAddToCart = By.xpath("(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]");
    private By cartIcon = By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']");

    public void addFirstProductToCart() {
        driver.findElement(firstProductAddToCart).click();
        System.out.println("First product added in cart");
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
