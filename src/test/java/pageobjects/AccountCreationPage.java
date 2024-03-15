package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.Readconfig;
import utility.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class AccountCreationPage {

    Readconfig r = new Readconfig();


    WebDriver ldriver;

    public AccountCreationPage(WebDriver rdriver)
    {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    @FindBy(css = "input#id_gender1")
    WebElement mrRadio;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(name = "customer_lastname")
    WebElement lastName;

    @FindBy(xpath = "//input[@type='password']")
    WebElement password;

    @FindBy(id = "days")
    WebElement dayofBirth;

    @FindBy(id = "months")
    WebElement monthofBirth;

    @FindBy(id = "years")
    WebElement yearofBirth;

    @FindBy(id = "newsletter")
    WebElement checkNewsLetter;

    @FindBy(xpath = "//span[text()='Register']")
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
        Select daySelection = new Select(dayofBirth);
        daySelection.selectByValue(r.readDay());

        Select monthSelection = new Select(monthofBirth);
        monthSelection.selectByValue(r.readMonth());

        Select yearSelection = new Select(yearofBirth);
        yearSelection.selectByValue(r.readYear());
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
