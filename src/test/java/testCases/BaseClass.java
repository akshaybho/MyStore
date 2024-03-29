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
    Readconfig read = new Readconfig();

    String url = read.getBaseUrl();

    public static Properties p;
    public static FileInputStream input;

    static String email = u.generateEmail();
    static String password = Utils.generateSecurePassword();

    //String browser = read.getBrowser();
    //Scanner sc = new Scanner(System.in);

    public static Logger log;



    public void setUp(BrowserType browser) throws IOException {
        System.out.println("Enter your preferred Browser");
        p = new Properties();

        input = new FileInputStream(System.getProperty("user.dir") + "\\testData\\credentials.properties");
        p.load(input);


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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //for logging
        log = LogManager.getLogger("MyStore");
        //sc.close();
        driver.get(url);
        log.info("url opened");

    }


    public void tearDown()
    {
        driver.close();
        driver.quit();
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
