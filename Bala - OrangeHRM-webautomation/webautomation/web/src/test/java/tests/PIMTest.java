package tests;

import base.BaseTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMPage;

public class PIMTest extends BaseTest {
    @Test
    public void testEmployeeCRUD() {
        LoginPage login = new LoginPage(driver);
        login.loginAs("Admin", "admin123");
        Assert.assertTrue(login.isLoginSuccessful(), "Login failed");

        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();

        pim.addEmployee("Jane", "Smith");
        // Assuming new employee ID auto-generated and visible
        String empId = driver.findElement(By.cssSelector("input[placeholder='Employee Id']")).getAttribute("value");

        Assert.assertTrue(pim.searchEmployee(empId), "Employee not found after add");

        pim.editFirstEmployee("Doe");
        Assert.assertTrue(pim.searchEmployee(empId), "Employee not found after edit");

        pim.deleteFirstEmployee();
        Assert.assertFalse(pim.searchEmployee(empId), "Employee still exists after delete");
    }
}
