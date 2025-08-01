package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class FiltersPage extends BasePage {
    public FiltersPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    private By filterButton = By.accessibilityId("test-Modal Selector Button");
    private By applyButton = By.xpath("//android.widget.TextView[@text='APPLY']");
    private By clearButton = By.xpath("//android.widget.TextView[@text='CLEAR']");

    public void openFilters() {
        driver.findElement(filterButton).click();
    }

    public void applyFilter() {
        driver.findElement(applyButton).click();
    }

    public void clearFilter() {
        driver.findElement(clearButton).click();
    }

    public boolean isFilterApplied() {
        return driver.getPageSource().contains("Filter");
    }
}
