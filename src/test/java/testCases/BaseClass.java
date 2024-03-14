package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utility.Readconfig;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    Readconfig read = new Readconfig();

    String url = read.getBaseUrl();

    public static WebDriver driver;

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
    }

    @AfterClass
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }
}
