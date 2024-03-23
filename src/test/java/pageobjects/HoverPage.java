package pageobjects;

import actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HoverPage {

    WebDriver ldriver;

    Action b = new Action();

    public HoverPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//a[text()='Women']")
    WebElement WomenTab;

    @FindBy(xpath = "(//a[text()='Dresses'])[2]")
    WebElement DressesTab;

    @FindBy(xpath = "//a[@title='Blouses']")
    WebElement WomenText;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a[text()='Evening Dresses']")
    WebElement DressesText;

    public void hoverOnWomen() throws InterruptedException
    {
        b.mouseHoverElement(ldriver, WomenTab);
        Thread.sleep(3000);
        String actualText = WomenText.getText();
        String expectedText = "Blouses";
        if(actualText.equals(expectedText))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }

    public void hoverOnDresses() throws InterruptedException {
        b.mouseHoverElement(ldriver,DressesTab);
        Thread.sleep(3000);
        String actual = DressesText.getText();
        String expected = "Evening Dresses";
        if(actual.equals(expected))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.fail();
        }
    }
}
