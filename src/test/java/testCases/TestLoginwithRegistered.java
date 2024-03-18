package testCases;

import org.testng.annotations.Test;
import pageobjects.IndexPage;
import pageobjects.MyAccountPage;
import pageobjects.RegisteredUserAccountPage;

import java.io.IOException;

public class TestLoginwithRegistered extends BaseClass{

    @Test(priority = 1)
    public void verifyLogin() throws IOException {
        IndexPage i = new IndexPage(driver);
        i.clickOSignIn();
        MyAccountPage m = new MyAccountPage(driver);
        m.enetrRegiEmail(email);
        m.eneterRegiPass(password);
        m.submitLoginBtn();

        RegisteredUserAccountPage rua = new RegisteredUserAccountPage(driver);
        String userName = rua.getUserName();

        if(userName.equals("Akshay Bhogale"))
        {
            System.out.println("====PASS====");
            captureScreenShot(driver,"verifyLogin");
        }
        else {
            captureScreenShot(driver,"verifyLogin");
            System.out.println("====FAIL====");
        }

    }
}
