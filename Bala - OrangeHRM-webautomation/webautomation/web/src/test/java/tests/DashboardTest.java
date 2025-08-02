package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends base.BaseTest {

    @Test
    public void validateDashboardWidgets() {
        LoginPage login = new LoginPage(driver);
        login.loginAs("Admin", "admin123");


        DashboardPage dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard not visible!");
        System.out.println("Dashboard header is displayed.");

        Assert.assertTrue(dashboardPage.isTimeAtWorkWidgetVisible(), "Time at Work widget not visible!");
        System.out.println("Time at Work widget is displayed.");

        Assert.assertTrue(dashboardPage.isMyActionsWidgetVisible(), "My Actions widget not visible!");
        System.out.println("My Actions widget is displayed.");
    }
}
