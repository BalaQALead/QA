package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    WebDriver driver;
    By userDropdown = By.xpath("//p[@class='oxd-userdropdown-name']");
    By logoutBtn = By.xpath("//a[text()='Logout']");

    public LogoutPage(WebDriver driver) { this.driver = driver; }

    public void logout() {
        driver.findElement(userDropdown).click();
        driver.findElement(logoutBtn).click();
        System.out.println("User logged out successfully");
    }

    public boolean isLoggedOut() {
        boolean atLogin = driver.getCurrentUrl().contains("auth/login");
        System.out.println("Logged out status: " + atLogin);
        return atLogin;
    }
}
