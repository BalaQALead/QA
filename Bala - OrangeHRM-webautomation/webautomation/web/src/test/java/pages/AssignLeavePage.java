package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignLeavePage {
    WebDriver driver;

    public AssignLeavePage(WebDriver driver) {
        this.driver = driver;
    }

    private By assignLeaveTab = By.xpath("//a[contains(text(),'Assign Leave')]");
    private By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By leaveType = By.xpath("//select");
    private By fromDate = By.xpath("//input[@placeholder='From Date']");
    private By toDate = By.xpath("//input[@placeholder='To Date']");
    private By assignBtn = By.xpath("//button[@type='submit']");

    public void assignLeave(String empName, String from, String to) {
        driver.findElement(assignLeaveTab).click();
        driver.findElement(employeeName).sendKeys(empName);
        driver.findElement(fromDate).clear();
        driver.findElement(fromDate).sendKeys(from);
        driver.findElement(toDate).clear();
        driver.findElement(toDate).sendKeys(to);
        driver.findElement(assignBtn).click();
        System.out.println("Leave assigned to " + empName);
    }
}
