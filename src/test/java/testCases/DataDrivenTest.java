package testCases;

import enums.BrowserType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import pageobjects.MyAccountPage;
import pageobjects.RegisteredUserAccountPage;
import utility.ReadExcel;

import java.io.IOException;

public class DataDrivenTest extends BaseClass {

    IndexPage ip;

    MyAccountPage mp;

    RegisteredUserAccountPage r;

    @Test(dataProvider = "LoginDataProvider")
    public void veriFyLogin(String userEmail, String userPassword, String expectedUserName) throws IOException {
        setUp(BrowserType.CHROME);
        ip = new IndexPage(driver);
        ip.clickOSignIn();
        mp = new MyAccountPage(driver);
        mp.enetrRegiEmail(userEmail);
        mp.eneterRegiPass(userPassword);
        mp.submitLoginBtn();
        r = new RegisteredUserAccountPage(driver);
        String userName = r.getUserName();
        if(userName.equals(expectedUserName))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
        r.clickOnSignOut();
        tearDown();
    }

    @DataProvider(name = "LoginDataProvider")
    public String[][] loginDataProvider()
    {
        String fileName = System.getProperty("user.dir")+"\\testData\\MyStoreTestData.xlsx";

        int ttlRows = ReadExcel.getRowCount(fileName, "LoginTestData");
        int ttlColoumns = ReadExcel.getColCount(fileName, "LoginTestData");

        String data [][] = new String[ttlRows-1][ttlColoumns];

        for(int i=1; i<ttlRows; i++)
        {
            for(int j=0; j<ttlColoumns; j++)
            {
                data[i-1][j] = ReadExcel.getCellValue(fileName, "LoginTestData", i,j);
            }
        }
        return data;
    }
}
