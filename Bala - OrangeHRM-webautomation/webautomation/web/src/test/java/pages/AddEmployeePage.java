package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {
    WebDriver driver;

    By pimMenu = By.xpath("//span[text()='PIM']");
    By addEmpBtn = By.xpath("//button[contains(., 'Add')]");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By saveBtn = By.cssSelector("button[type='submit']");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addEmployee(String fname, String lname) {
        driver.findElement(pimMenu).click();
        driver.findElement(addEmpBtn).click();
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(saveBtn).click();
    }
}
