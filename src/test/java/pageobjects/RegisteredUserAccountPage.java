package pageobjects;

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
    @FindBy(xpath = "//a[@title = 'View my customer account']")
    WebElement userName;


    public String getUserName()
    {
        String text = userName.getText();

        return text;
    }


}
