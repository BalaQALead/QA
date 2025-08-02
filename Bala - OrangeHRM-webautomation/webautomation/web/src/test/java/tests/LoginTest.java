package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginSuccess() {
        LoginPage login = new LoginPage(driver);
        login.loginAs("Admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed!");
    }
}
