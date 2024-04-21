package pageobjects;

import constants.ColourValidationPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Readconfig;

public class ColourValidationPage {

    Readconfig r = new Readconfig();
    WebDriver ldriver;
    public ColourValidationPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(xpath = ColourValidationPageLocators.T_SHIRTS)
    WebElement Tshirts;

    @FindBy(xpath = ColourValidationPageLocators.CHOOSE_TSHIRT)
    WebElement chooseTshirt;

    @FindBy(css = ColourValidationPageLocators.SELECT_COLOUR)
    WebElement colourSelect;

    public void verifyColour() throws InterruptedException {
        Tshirts.click();
        Thread.sleep(3000);
        chooseTshirt.click();
        Thread.sleep(3000);
        colourSelect.click();
        Thread.sleep(3000);
        String imgURL = ldriver.getCurrentUrl();
        String expURL = r.getDressURL();
        if(imgURL.equals(expURL))
        {
            System.out.println("Dress color is as per expectation");
        }
        else
        {
            System.out.println("Dress color is not meeting expectations");
        }
    }
}
