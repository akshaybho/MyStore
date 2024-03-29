package testCases;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import pageobjects.MyAccountPage;
import pageobjects.SearchProductPage;

import java.io.IOException;
import java.util.Properties;

public class SearchProductTest extends BaseClass {




    @Test
    public void verifyProductTest() throws InterruptedException, IOException {

        setUp(BrowserType.CHROME);
        String mail = p.getProperty("emailId");
        String pass = BaseClass.decodeString(p.getProperty("password"));

        IndexPage ip = new IndexPage(driver);
        ip.clickOSignIn();
        Thread.sleep(3000);

        MyAccountPage mp = new MyAccountPage(driver);
        mp.enetrRegiEmail(mail);
        Thread.sleep(3000);
        mp.eneterRegiPass(pass);
        Thread.sleep(3000);
        mp.submitLoginBtn();
        Thread.sleep(3000);

        SearchProductPage sp = new SearchProductPage(driver);
        sp.searchItem();
        Thread.sleep(3000);
        sp.clickOnSearchButton();
        Thread.sleep(3000);
        sp.verifyProduct();
        tearDown();

    }

}
