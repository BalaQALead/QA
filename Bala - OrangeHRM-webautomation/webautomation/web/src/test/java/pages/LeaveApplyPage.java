package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeaveApplyPage {
    WebDriver driver;

    public LeaveApplyPage(WebDriver driver) {
        this.driver = driver;
    }

    private By leaveMenu = By.xpath("//span[text()='Leave']");
    private By applyOption = By.xpath("//a[contains(@href,'apply')]");
    private By leaveType = By.xpath("//label[text()='Leave Type']/following::div[1]");
    private By selectType = By.xpath("//span[text()='CAN - Personal']");
    private By fromDate = By.xpath("//label[text()='From Date']/following::input[1]");
    private By toDate = By.xpath("//label[text()='To Date']/following::input[1]");
    private By comment = By.xpath("//textarea");
    private By applyBtn = By.xpath("//button[@type='submit']");

    public void applyLeave(String from, String to, String commentText) throws InterruptedException {
        driver.findElement(leaveMenu).click();
        driver.findElement(applyOption).click();
        driver.findElement(leaveType).click();
        driver.findElement(selectType).click();
        driver.findElement(fromDate).sendKeys(from);
        driver.findElement(toDate).sendKeys(to);
        driver.findElement(comment).sendKeys(commentText);
        driver.findElement(applyBtn).click();
    }
}
