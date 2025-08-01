package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MenuPage {
    private AndroidDriver driver;

    private By menuButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");
    private By logout = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]");

    public MenuPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        driver.findElement(menuButton).click();
        driver.findElement(logout).click();
    }
}
