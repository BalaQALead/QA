package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage {
    WebDriver driver;
    By pimMenu = By.xpath("//span[text()='PIM']");
    By addBtn = By.xpath("//button[contains(., 'Add')]");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By saveBtn = By.xpath("//button[@type='submit']");
    By empIdSearch = By.cssSelector("input[placeholder='Type for hints...']");
    By searchBtn = By.xpath("//button[@type='submit']");
    By empNameCell = By.xpath("//div[contains(@class,'oxd-table-body')]/div[1]//div[3]");
    By editBtn = By.xpath("//button[contains(., 'Edit')]");
    By deleteBtn = By.xpath("//button[text()=' Delete Selected ']");

    public PIMPage(WebDriver driver) { this.driver = driver; }

    public void goToPIM() {
        driver.findElement(pimMenu).click();
        System.out.println("Navigated to PIM page");
    }
// To added the Employee
    public void addEmployee(String fn, String ln) {
        driver.findElement(addBtn).click();
        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(saveBtn).click();
        System.out.println("Added employee: " + fn + " " + ln);
    }
 // To search the Employee

    public boolean searchEmployee(String empId) {
        goToPIM();
        driver.findElement(empIdSearch).sendKeys(empId);
        driver.findElement(searchBtn).click();
        boolean found = driver.findElements(empNameCell).size() > 0;
        System.out.println("Employee found status: " + found);
        return found;
    }
 // To edited the Employee

    public void editFirstEmployee(String newLastName) {
        driver.findElement(editBtn).click();
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(newLastName);
        driver.findElement(saveBtn).click();
        System.out.println("Edited employee last name to: " + newLastName);
    }
//// To deleted the Employee

    public void deleteFirstEmployee() {
        driver.findElement(deleteBtn).click();
        driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
        System.out.println("Deleted first employee in list");
    }
}
