package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PerformancePage;

public class PerformanceTest extends BaseTest {

    @Test
    public void validatePerformanceModule() {
        LoginPage login = new LoginPage(driver);
        PerformancePage performance = new PerformancePage(driver);

        login.login("Admin", "admin123");
        performance.navigateToKPISection();
    }
}
