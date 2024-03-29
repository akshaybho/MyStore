package testCases;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.HoverPage;

import java.io.IOException;

public class HoverPageTest extends BaseClass {

    HoverPage hp;



    @Test
    public void hoverTest() throws InterruptedException, IOException {
        setUp(BrowserType.CHROME);
        hp = new HoverPage(driver);
        hp.hoverOnWomen();
        hp.hoverOnDresses();
        tearDown();
    }
}
