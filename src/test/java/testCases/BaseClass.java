package testCases;


import com.aventstack.extentreports.utils.FileUtil;
import driverFactory.Drivers;
import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.utils.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utility.Readconfig;
import utility.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BaseClass extends Drivers {
    static Utils u = new Utils();

    static String email = u.generateEmail();
    static String password = Utils.generateSecurePassword();
    public static Logger log;
    public void setUp(BrowserType browser) throws IOException {
        readtestData();
        switch(browser)
        {
            case CHROME:
                getChrome();
                break;

            case FIREFOX:
               getFirefox();
                break;

            case EDGE:
               getEdge();
                break;

            case HEADLESS:
               getHeadless();
                break;

        }
        driverMethods();
        log = LogManager.getLogger("MyStore");
        log.info("url opened");
    }
    public void tearDown()
    {
        closeBrowser();
    }
    public void captureScreenShot(WebDriver driver, String testName) throws IOException {
        TakesScreenshot screenShot = ((TakesScreenshot)driver);

        File src = screenShot.getScreenshotAs(OutputType.FILE);

        File dest = new File(System.getProperty("user.dir")+"//ScreenShots//"+testName+".png");

        FileUtils.copyFile(src, dest);
    }
    public static String decodeString(String pwd) throws IOException
    {

            byte []decodedString = Base64.decodeBase64(pwd);
            return (new String(decodedString));
    }
}
