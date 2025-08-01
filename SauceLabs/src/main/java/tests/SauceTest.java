package tests;

import base.AbstractBaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.MenuPage;

public class SauceTest extends AbstractBaseTest {

    @Test
    public void fullTestFlow() throws InterruptedException {
        // To be Initialize page objects
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        MenuPage menuPage = new MenuPage(driver);

        // To be perform full workflow
        loginPage.login("standard_user", "secret_sauce");
        productPage.applyFilter();
        productPage.viewProduct();
        cartPage.addItemToCart();
        checkoutPage.completeCheckout("Bala", "Subramani", "625016");
        menuPage.logout();
    }
}
