package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LeaveApplyPage;
import pages.LeaveListPage;

public class LeaveModuleTest extends BaseTest {

    @Test
    public void testApplyAndViewLeave() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.loginAs("Admin", "admin123");


        LeaveApplyPage apply = new LeaveApplyPage(driver);
        apply.applyLeave("2025-08-05", "2025-08-06", "Medical leave");

        LeaveListPage list = new LeaveListPage(driver);
        boolean isLeaveVisible = list.viewLeaveList();

        Assert.assertTrue(isLeaveVisible, "Leave list is not visible.");
    }
}
