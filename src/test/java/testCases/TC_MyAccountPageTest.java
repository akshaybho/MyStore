package testCases;

import org.testng.annotations.Test;
import pageobjects.IndexPage;
import pageobjects.MyAccountPage;
import utility.Utils;

public class TC_MyAccountPageTest extends BaseClass {

    Utils u = new Utils();

    @Test
    public void verifyRegistrationAndLogin() throws InterruptedException {
        driver.get(url);
        log.info("url opened");

        IndexPage ip = new IndexPage(driver);
        ip.clickOSignIn();
        log.info("click on sign-in");

        MyAccountPage mp = new MyAccountPage(driver);
        mp.enterEmailAddress(u.generateEmail());
        Thread.sleep(3000);
        log.info("enter an email address");
        mp.clickOnSubmit();
        Thread.sleep(3000);
        log.info("click on create an account button");
    }

}
