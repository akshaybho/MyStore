package pageobjects;

import constants.RegisteredUserAccountPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccountPage {

    WebDriver ldriver;


    public RegisteredUserAccountPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(xpath = RegisteredUserAccountPageLocators.USERNAME)
    WebElement userName;

    @FindBy(linkText = RegisteredUserAccountPageLocators.SIGN_OUT_BUTTON)
    WebElement signOut;

    public String getUserName()
    {
        String text = userName.getText();

        return text;
    }

    public void clickOnSignOut()
    {
        signOut.click();
    }

}
