package pageobjects;

import actiondriver.Action;
import constants.AccountCreationPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Readconfig;

public class AccountCreationPage {

    Readconfig r = new Readconfig();

    Action a = new Action();
    WebDriver ldriver;

    public AccountCreationPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(css = AccountCreationPageLocators.MR_RADIO_BUTTON)
    WebElement mrRadio;

    @FindBy(id = AccountCreationPageLocators.FIRSTNAME)
    WebElement firstName;

    @FindBy(name = AccountCreationPageLocators.LASTNAME)
    WebElement lastName;

    @FindBy(xpath = AccountCreationPageLocators.PASSWORD)
    WebElement password;

    @FindBy(id = AccountCreationPageLocators.DAY_OF_BIRTH)
    WebElement dayofBirth;

    @FindBy(id = AccountCreationPageLocators.MONTH_OF_BIRTH)
    WebElement monthofBirth;

    @FindBy(id = AccountCreationPageLocators.YEAR_OF_BIRTH)
    WebElement yearofBirth;

    @FindBy(id = AccountCreationPageLocators.NEWS_LETTER)
    WebElement checkNewsLetter;

    @FindBy(xpath = AccountCreationPageLocators.REGISTER_BUTTON)
    WebElement registerBtn;

    public void clickOnRadioButton()
    {
        mrRadio.click();
    }
    public void enterFirstName()
    {
        firstName.sendKeys("Akshay");
    }

    public void enterLastName()
    {
        lastName.sendKeys("Bhogale");
    }

    public void enterPassword(String pwd)
    {
        password.sendKeys(pwd);
    }

    public void selectDOB()
    {
        a.selectByValue(dayofBirth, r.readDay());
        a.selectByValue(monthofBirth, r.readMonth());
        a.selectByValue(yearofBirth, r.readYear());
    }

    public void clickOnCheckBox()
    {
        checkNewsLetter.click();
    }

    public void clickOnRegister()
    {
        registerBtn.click();
    }
}
