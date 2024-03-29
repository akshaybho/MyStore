package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.Readconfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Drivers {
    public static Properties p;
    public static FileInputStream input;

    protected static WebDriver driver;
    static Readconfig read = new Readconfig();
    static String URL = read.getBaseUrl();
    public WebDriver getChrome()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
    public WebDriver getFirefox()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }
    public WebDriver getEdge()
    {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }
    public WebDriver getHeadless()
    {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("headless");
        driver = new ChromeDriver(option);
        return driver;
    }
    public static void driverMethods()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);

    }
    public static void closeBrowser()
    {
        driver.close();
        driver.quit();
    }

    public static void readtestData() throws IOException {
        p = new Properties();
        input = new FileInputStream(System.getProperty("user.dir") + "\\testData\\credentials.properties");
        p.load(input);
    }
}
