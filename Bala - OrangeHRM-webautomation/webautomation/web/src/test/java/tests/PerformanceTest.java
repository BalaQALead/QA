package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.PerformancePage;

public class PerformanceTest extends BaseTest {

    @Test
    public void validatePerformanceModule() {
        LoginPage login = new LoginPage(driver);
        PerformancePage performance = new PerformancePage(driver);

        login.loginAs("Admin", "admin123");
        performance.navigateToKPISection();
    }
}
