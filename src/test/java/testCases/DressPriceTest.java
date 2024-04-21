package testCases;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.DressPricePage;
import utility.Utils;

import java.io.IOException;

public class DressPriceTest extends BaseClass{

    DressPricePage dp;

    @Test
    public void validatePrices() throws InterruptedException, IOException {
        setUp(BrowserType.CHROME);
        dp = new DressPricePage(driver);
        dp.clickOnDresses();
        Thread.sleep(2000);
        dp.selectLowest();
        Thread.sleep(2000);
        dp.validateOrderOfPrices();
        Thread.sleep(3000);
        tearDown();

        setUp(BrowserType.EDGE);
        dp = new DressPricePage(driver);
        dp.clickOnDresses();
        Thread.sleep(2000);
        dp.selectLowest();
        Thread.sleep(2000);
        dp.validateOrderOfPrices();
        Thread.sleep(3000);
        tearDown();
    }
}
