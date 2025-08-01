package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LeavePage;

public class LeaveTest extends BaseTest {
    @Test
    public void testLeaveModules() {
        LoginPage login = new LoginPage(driver);
        login.loginAs("Admin", "admin123");
        Assert.assertTrue(login.isLoginSuccessful(), "Login failed");

        LeavePage leave = new LeavePage(driver);
        leave.applyLeave("2025-08-10", "2025-08-11", "Family event");
        Assert.assertTrue(leave.viewLeaveList(), "Leave list not visible");

        leave.navigateMyLeave();
        leave.navigateAssignLeave();
        leave.navigateEntitlements();
        System.out.println("Leave navigation modules executed successfully");
    }
}
