package tests;

import base.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends AbstractBaseTest {

    @Test
    public void testCompleteCheckoutFlow() {
        new LoginPage(driver).login("standard_user", "secret_sauce");

        ProductListPage productListPage = new ProductListPage(driver);
        Assert.assertTrue(productListPage.isProductPageDisplayed(), "Product list not loaded.");

        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.addFirstProductToCart();
        addToCartPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart(), "Product not found in cart.");
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutDetails("John", "Doe", "12345");
        checkoutPage.completeCheckout();
        Assert.assertTrue(checkoutPage.isCheckoutSuccess(), "Checkout was not successful.");
    }
}
