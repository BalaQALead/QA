package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void loginAs(String user, String pass) {
        System.out.println("Entering username and password");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
        System.out.println("Successfully enter the login details");
    }

    public boolean isLoginSuccessful() {
        boolean success = driver.getCurrentUrl().contains("dashboard");
        System.out.println("Login success status: " + success);
        return success;
    }
}
