package testCases;

import enums.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountCreationPage;
import pageobjects.IndexPage;
import pageobjects.MyAccountPage;
import pageobjects.RegisteredUserAccountPage;
import utility.Utils;

import java.io.IOException;

public class TC_MyAccountPageTest extends BaseClass {





    @Test(priority = 0)
    public void verifyRegistrationAndLogin() throws InterruptedException, IOException {

        setUp(BrowserType.CHROME);
        IndexPage ip = new IndexPage(driver);
        ip.clickOSignIn();
        log.info("click on sign-in");

        MyAccountPage mp = new MyAccountPage(driver);
        mp.enterEmailAddress(email);
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

        tearDown();
    }





}
