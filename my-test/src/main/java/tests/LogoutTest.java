package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogoutFlow() {
        LoginPage login = new LoginPage(driver);
        login.loginAs("Admin", "admin123");
        Assert.assertTrue(login.isLoginSuccessful(), "Login failed");

        LogoutPage logout = new LogoutPage(driver);
        logout.logout();
        Assert.assertTrue(logout.isLoggedOut(), "Logout not successful");
    }
}
