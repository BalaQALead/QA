package pages;

import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class LoginPage {
    private AndroidDriver driver;

    private By usernameField = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    private By passwordField = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    private By loginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
		System.out.println("Username is displayed");

        driver.findElement(passwordField).sendKeys(password);
		System.out.println("Password is displayed");

        driver.findElement(loginButton).click();
		System.out.println("Login successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}

 