package testCases;

import org.testng.annotations.Test;
import pageobjects.HoverPage;

public class HoverPageTest extends BaseClass {

    HoverPage hp;
    @Test
    public void hoverTest() throws InterruptedException {
        hp = new HoverPage(driver);
        hp.hoverOnWomen();
        hp.hoverOnDresses();
    }
}
