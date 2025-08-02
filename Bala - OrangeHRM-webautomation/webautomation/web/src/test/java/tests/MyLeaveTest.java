package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyLeavePage;
import base.BaseTest;

public class MyLeaveTest extends BaseTest {

    @Test
    public void verifyMyLeaveSection() {
        MyLeavePage myLeavePage = new MyLeavePage(driver);
        myLeavePage.clickMyLeaveTab();

        Assert.assertTrue(myLeavePage.isLeaveListDisplayed(), "Leave list is not displayed");
        System.out.println("Leave list is displayed successfully.");
    }
}
