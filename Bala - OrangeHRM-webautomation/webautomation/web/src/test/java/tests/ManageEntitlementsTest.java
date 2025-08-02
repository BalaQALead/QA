package tests;

import org.testng.annotations.Test;
import pages.ManageEntitlementsPage;
import base.BaseTest;

public class ManageEntitlementsTest extends BaseTest {

    @Test
    public void checkManageEntitlements() {
        ManageEntitlementsPage page = new ManageEntitlementsPage(driver);
        page.openManageEntitlements();
        System.out.println("Manage Entitlements test completed.");
    }
}
