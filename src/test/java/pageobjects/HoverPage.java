package pageobjects;

import actiondriver.Action;
import constants.HoverPageLocators;
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
    @FindBy(xpath = HoverPageLocators.WOMEN_TAB)
    WebElement WomenTab;

    @FindBy(xpath = HoverPageLocators.DRESSES_TAB)
    WebElement DressesTab;

    @FindBy(xpath = HoverPageLocators.WOMEN_TEXT)
    WebElement WomenText;

    @FindBy(xpath = HoverPageLocators.DRESSES_TEXT)
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
