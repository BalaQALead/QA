package tests;

import base.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends AbstractBaseTest {

    @Test
    public void testLogoutFunctionality() {
        new LoginPage(driver).login("standard_user", "secret_sauce");

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();

        Assert.assertTrue(logoutPage.isAtLoginScreen(), "Logout failed. Not redirected to login screen.");
    }
}
