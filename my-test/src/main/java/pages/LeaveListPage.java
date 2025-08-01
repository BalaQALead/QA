package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeaveListPage {
    WebDriver driver;

    public LeaveListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By leaveMenu = By.xpath("//span[text()='Leave']");
    private By leaveList = By.xpath("//a[contains(@href,'viewLeaveList')]");
    private By searchBtn = By.xpath("//button[@type='submit']");
    private By leaveTable = By.xpath("//div[@class='oxd-table-body']");

    public boolean viewLeaveList() {
        driver.findElement(leaveMenu).click();
        driver.findElement(leaveList).click();
        driver.findElement(searchBtn).click();
        return driver.findElement(leaveTable).isDisplayed();
    }
}
