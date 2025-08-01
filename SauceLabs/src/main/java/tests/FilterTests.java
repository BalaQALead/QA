package tests;

import base.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FiltersPage;
import pages.LoginPage;
import pages.ProductListPage;

public class FiltersTest extends AbstractBaseTest {

    @Test
    public void testApplyAndClearFilters() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductListPage productListPage = new ProductListPage(driver);
        Assert.assertTrue(productListPage.isProductPageDisplayed(), "Product List not displayed!");

        FiltersPage filtersPage = new FiltersPage(driver);
        filtersPage.openFilters();
        filtersPage.applyFilter();
        Assert.assertTrue(filtersPage.isFilterApplied(), "Filter not applied!");
        filtersPage.openFilters();
        filtersPage.clearFilter();
        
    }
}
