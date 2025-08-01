package tests;

import base.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductListPage;

public class ProductListTest extends AbstractBaseTest {
    @Test
    public void verifyProductList() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        Assert.assertTrue(new ProductListPage(driver).isProductPageDisplayed(), "Products not displayed!");
        System.out.println("Product is displayed");
    }
}
