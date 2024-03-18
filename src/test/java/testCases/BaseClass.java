package testCases;

import com.aventstack.extentreports.utils.FileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
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
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    static Utils u = new Utils();
    Readconfig read = new Readconfig();

    String url = read.getBaseUrl();

    public static WebDriver driver;

    static String email = u.generateEmail();
    static String password = Utils.generateSecurePassword();

    String browser = read.getBrowser();
    //Scanner sc = new Scanner(System.in);

    public static Logger log;

    @BeforeClass
    public void setUp()
    {
        System.out.println("Enter your preferred Browser");


        switch(browser.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "headless":
                WebDriverManager.chromiumdriver().setup();
                ChromeOptions option = new ChromeOptions();
                option.addArguments("headless");
                driver = new ChromeDriver(option);
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

    @AfterClass
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
}
