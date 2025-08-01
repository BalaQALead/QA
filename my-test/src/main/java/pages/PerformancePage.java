package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PerformancePage {
    private WebDriver driver;

    public PerformancePage(WebDriver driver) {
        this.driver = driver;
    }

    private By performanceTab = By.xpath("//span[text()='Performance']");
    private By configureMenu = By.xpath("//span[text()='Configure']");
    private By kpiSubMenu = By.xpath("//a[text()='KPIs']");
    private By kpiHeader = By.xpath("//h6[text()='Key Performance Indicators']");

    public void navigateToKPISection() {
        driver.findElement(performanceTab).click();
        driver.findElement(configureMenu).click();
        driver.findElement(kpiSubMenu).click();

        boolean isKPIVisible = driver.findElement(kpiHeader).isDisplayed();
        Assert.assertTrue(isKPIVisible, "KPI page should be visible");
        System.out.println("Navigated to Performance > KPI page.");
    }
}
