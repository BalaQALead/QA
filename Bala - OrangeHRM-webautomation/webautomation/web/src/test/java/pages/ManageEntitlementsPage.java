package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageEntitlementsPage {
    WebDriver driver;

    public ManageEntitlementsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By leaveTab = By.xpath("//span[text()='Leave']");
    private By entitlements = By.xpath("//a[contains(text(),'Entitlements')]");
    private By manageEntitlements = By.xpath("//a[contains(text(),'Manage Entitlements')]");
    private By searchBtn = By.xpath("//button[@type='submit']");

    public void openManageEntitlements() {
        driver.findElement(leaveTab).click();
        driver.findElement(entitlements).click();
        driver.findElement(manageEntitlements).click();
        driver.findElement(searchBtn).click();
        System.out.println("Accessed Manage Entitlements and searched.");
    }
}
