package testCases;

import org.testng.annotations.Test;
import pageobjects.CartValidationPage;

public class CartValidationPageTest extends BaseClass {

    @Test
    public void verifyCartItem() throws InterruptedException {
        CartValidationPage c = new CartValidationPage(driver);
        c.clickOnTshirts();
        Thread.sleep(2000);
        c.selectItem();
        Thread.sleep(2000);
        c.chooseSize();
        Thread.sleep(2000);
        c.clickOnAddtoCart();
        Thread.sleep(2000);
        c.proceedToCheckOut();
        Thread.sleep(2000);
        c.cartProductVerify();
        Thread.sleep(2000);
    }
}
