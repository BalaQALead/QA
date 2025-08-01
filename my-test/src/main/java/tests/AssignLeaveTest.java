package testcases;

import org.testng.annotations.Test;
import pages.AssignLeavePage;
import base.BaseTest;

public class AssignLeaveTest extends BaseTest {

    @Test
    public void assignLeaveToEmployee() {
        AssignLeavePage assignLeavePage = new AssignLeavePage(driver);
        assignLeavePage.assignLeave("Paul Collings", "2024-08-01", "2024-08-03");
        System.out.println("Assign leave test completed.");
    }
}
