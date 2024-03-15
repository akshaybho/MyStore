package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountCreationPage;
import pageobjects.IndexPage;
import pageobjects.MyAccountPage;
import pageobjects.RegisteredUserAccountPage;
import utility.Utils;

public class TC_MyAccountPageTest extends BaseClass {

    Utils u = new Utils();

    String password = Utils.generateSecurePassword();

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

        AccountCreationPage acp = new AccountCreationPage(driver);

        acp.clickOnRadioButton();
        Thread.sleep(3000);
        acp.enterFirstName();
        Thread.sleep(3000);
        acp.enterLastName();
        Thread.sleep(3000);
        acp.enterPassword(password);
        Thread.sleep(3000);
        acp.selectDOB();
        Thread.sleep(3000);
        acp.clickOnCheckBox();
        log.info("User enter the details");
        Thread.sleep(3000);
       acp.clickOnRegister();
        log.info("User click on register button");
        Thread.sleep(3000);

        RegisteredUserAccountPage rua = new RegisteredUserAccountPage(driver);
        String userName = rua.getUserName();

        Assert.assertEquals("Akshay Bhogale", userName);

    }



}
