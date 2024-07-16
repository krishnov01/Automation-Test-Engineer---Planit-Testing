package cart;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ShopPage;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class CartTests extends BaseTests {
    @Test
    public void verifyTotal(){
        SoftAssert softAssert = new SoftAssert();
        ShopPage shopPage = homePage.clickShopPage();
        double stuffedFrogSubtotal = shopPage.buyStuffedFrog(2);
        String stuffedFrogPrice = shopPage.productPrices(2);
        double fluffyBunnySubtotal = shopPage.buyFluffyBunny(4);
        String fluffyBunnyPrice = shopPage.productPrices(4);
        double valentineBearSubtotal = shopPage.buyValentineBear(7);
        String valentineBearPrice = shopPage.productPrices(7);
        CartPage cartPage = shopPage.clickCartPage();

        // Verify the price for each product
        assertEquals(cartPage.productPrice("Stuffed Frog"),stuffedFrogPrice);
        assertEquals(cartPage.productPrice("Fluffy Bunny"),fluffyBunnyPrice);
        assertEquals(cartPage.productPrice("Valentine Bear"),valentineBearPrice);

        //Verify Subtotal for each product
        assertEquals(stuffedFrogSubtotal, cartPage.subtotal("Stuffed Frog"));
        assertEquals(fluffyBunnySubtotal, cartPage.subtotal("Fluffy Bunny"));
        softAssert.assertEquals(valentineBearSubtotal, cartPage.subtotal("Valentine Bear"));

        //Verify that total = sum(subtotals)
        double total = stuffedFrogSubtotal+fluffyBunnySubtotal+valentineBearSubtotal;
        assertEquals(total, cartPage.getTotalPrice());
        softAssert.assertAll();

    }
}
