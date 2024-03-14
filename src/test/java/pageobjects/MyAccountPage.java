package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver ldriver;

    public MyAccountPage(WebDriver rdriver)
    {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id ="email_create")
    WebElement createEmailId;

    @FindBy(css = "button#SubmitCreate")
    WebElement SubmitCreate;

    public void enterEmailAddress(String newEmail)
    {
        createEmailId.sendKeys(newEmail);
    }

    public void clickOnSubmit()
    {

        SubmitCreate.click();
    }
}
