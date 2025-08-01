package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    public CheckoutPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    private By firstName = By.xpath("//android.widget.EditText[@content-desc='test-First Name']");
    private By lastName = By.xpath("//android.widget.EditText[@content-desc='test-Last Name']");
    private By postalCode = By.xpath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']");
    private By continueButton = By.xpath("//android.view.ViewGroup[@content-desc='test-CONTINUE']");
    private By finishButton = By.xpath("//android.view.ViewGroup[@content-desc='test-FINISH']");
    private By successMessage = By.xpath("//android.widget.TextView[@text='CHECKOUT: COMPLETE!']");

    public void enterCheckoutDetails(String fName, String lName, String zip) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void completeCheckout() {
        WebElement button = driver.findElement(continueButton));
        button.click();
        driver.findElement(finishButton).click();
        System.out.println("Checkout screen successfully");
    }

    public boolean isCheckoutSuccess() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
