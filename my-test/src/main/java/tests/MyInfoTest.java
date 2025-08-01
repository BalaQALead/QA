package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyInfoPage;

public class MyInfoTest extends BaseTest {

    @Test
    public void validateMyInfoSection() {
        LoginPage login = new LoginPage(driver);
        MyInfoPage myInfo = new MyInfoPage(driver);

        login.login("Admin", "admin123");
        myInfo.openMyInfoSection();
    }
}
