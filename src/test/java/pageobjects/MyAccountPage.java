package pageobjects;

import constants.MyAccountPageLocators;
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

    @FindBy(id = MyAccountPageLocators.CREATE_EMAILID_BUTTON)
    WebElement createEmailId;

    @FindBy(css = MyAccountPageLocators.SUBMIT_BUTTON)
    WebElement SubmitCreate;

    @FindBy(id = MyAccountPageLocators.WRITE_EMAILID)
    WebElement RegEmail;

    @FindBy(id = MyAccountPageLocators.WRITE_PASSWORD)
    WebElement Regpassword;

    @FindBy(id = MyAccountPageLocators.SUBMIT_LOGIN_BUTTON)
    WebElement submitLogin;

    public void enterEmailAddress(String newEmail)
    {
        createEmailId.sendKeys(newEmail);
    }

    public void clickOnSubmit()
    {

        SubmitCreate.click();
    }

    public void enetrRegiEmail(String mail)
    {
        RegEmail.sendKeys(mail);
    }

    public void eneterRegiPass(String pass)
    {
        Regpassword.sendKeys(pass);
    }

    public void submitLoginBtn()
    {
        submitLogin.click();
    }
}
