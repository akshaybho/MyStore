package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {

    protected WebDriver driver;


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

}
