package tests;

import base.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductListPage;

public class ProductListTest extends AbstractBaseTest {

    @Test
    public void verifyProductListDisplayedAfterLogin() {
        // Step 1: Log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Verify product list is visible
        ProductListPage productListPage = new ProductListPage(driver);
        boolean isDisplayed = productListPage.isProductPageDisplayed();

        // Step 3: Assertion
        Assert.assertTrue(isDisplayed, "Product list is NOT displayed after login!");
    }
}
