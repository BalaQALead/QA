package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LogoutPage extends BasePage {

    public LogoutPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    private By menuButton = By.xpath("//android.view.ViewGroup[@content-desc='test-Menu']");
    private By logoutLink = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGOUT']");
    private By loginScreenIdentifier = By.xpath("//android.widget.TextView[@text='Login']");

    public void logout() {
        driver.findElement(menuButton).click();
        driver.findElement(logoutLink).click();
    }

    public boolean isAtLoginScreen() {
        return driver.findElement(loginScreenIdentifier).isDisplayed();
    }
}
