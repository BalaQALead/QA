package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyLeavePage {
    WebDriver driver;

    public MyLeavePage(WebDriver driver) {
        this.driver = driver;
    }

    private By myLeaveTab = By.xpath("//a[contains(text(),'My Leave')]");
    private By leaveListTable = By.xpath("//div[@class='oxd-table-body']");

    public void clickMyLeaveTab() {
        driver.findElement(myLeaveTab).click();
        System.out.println("Clicked on My Leave tab.");
    }

    public boolean isLeaveListDisplayed() {
        return driver.findElement(leaveListTable).isDisplayed();
    }
}
