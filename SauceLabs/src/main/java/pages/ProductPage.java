package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductPage {
    private AndroidDriver driver;

    private By productItem = By.xpath("//android.widget.TextView[@index='2']");
    private By filterButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]");
    private By nameAZOption = By.xpath("//android.widget.TextView[@text=\"Name (A to Z)\"]");

    public ProductPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void viewProduct() {
        driver.findElement(productItem).click();
    }

    public void applyFilter() {
        driver.findElement(filterButton).click();
        driver.findElement(nameAZOption).click();
    }
}
