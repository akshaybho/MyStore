package testCases;

import org.testng.annotations.Test;
import pageobjects.DressPricePage;
import utility.Utils;

public class DressPriceTest extends BaseClass{

    @Test
    public void validatePrices() throws InterruptedException {
        DressPricePage dp = new DressPricePage(driver);
        dp.clickOnDresses();
        Thread.sleep(2000);
        dp.selectLowest();
        Thread.sleep(2000);
        dp.validateOrderOfPrices();
        Thread.sleep(3000);
    }
}
