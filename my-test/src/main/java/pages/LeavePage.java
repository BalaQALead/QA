package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage {
    WebDriver driver;
    By leaveMenu = By.xpath("//span[text()='Leave']");
    By applyLink = By.xpath("//a[contains(@href,'apply')]");
    By fromDate = By.xpath("//label[text()='From Date']/following::input[1]");
    By toDate = By.xpath("//label[text()='To Date']/following::input[1]");
    By commentBox = By.tagName("textarea");
    By applyBtn = By.xpath("//button[@type='submit']");
    By viewListLink = By.xpath("//a[contains(., 'Leave List')]");
    By searchBtn = By.xpath("//button[@type='submit']");
    By leaveTable = By.xpath("//div[@class='oxd-table-body']");
    By myLeaveLink = By.xpath("//a[contains(., 'My Leave')]");
    By assignLeaveLink = By.xpath("//a[contains(., 'Assign Leave')]");
    By entitlementsLink = By.xpath("//a[contains(., 'Entitlements')]");

    public LeavePage(WebDriver driver) { this.driver = driver; }

    public void applyLeave(String from, String to, String comment) {
        driver.findElement(leaveMenu).click();
        driver.findElement(applyLink).click();
        driver.findElement(fromDate).sendKeys(from);
        driver.findElement(toDate).sendKeys(to);
        driver.findElement(commentBox).sendKeys(comment);
        driver.findElement(applyBtn).click();
        System.out.println("Leave applied from " + from + " to " + to);
    }

    public boolean viewLeaveList() {
        driver.findElement(leaveMenu).click();
        driver.findElement(viewListLink).click();
        driver.findElement(searchBtn).click();
        boolean displayed = driver.findElement(leaveTable).isDisplayed();
        System.out.println("Leave list displayed: " + displayed);
        return displayed;
    }

    public void navigateMyLeave() {
        driver.findElement(leaveMenu).click();
        driver.findElement(myLeaveLink).click();
        System.out.println("Navigated to My Leave section");
    }

    public void navigateAssignLeave() {
        driver.findElement(leaveMenu).click();
        driver.findElement(assignLeaveLink).click();
        System.out.println("Navigated to Assign Leave section");
    }

    public void navigateEntitlements() {
        driver.findElement(leaveMenu).click();
        driver.findElement(entitlementsLink).click();
        System.out.println("Navigated to Entitlements section");
    }
}
