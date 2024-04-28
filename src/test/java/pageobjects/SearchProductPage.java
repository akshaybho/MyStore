package pageobjects;

import actiondriver.Action;
import constants.SearchProductPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchProductPage {

    WebDriver ldriver;

    public SearchProductPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    Action a = new Action();
    @FindBy(id = SearchProductPageLocators.SEARCH_BAR)
    WebElement searchBar;

    @FindBy(name = SearchProductPageLocators.SUBMIT_BUTTON)
    WebElement submitBtn;

    @FindBy(xpath = SearchProductPageLocators.PRODUCT_TEXT)
    WebElement productText;


    public void searchItem() throws InterruptedException {
        searchBar.click();
        Thread.sleep(3000);
        searchBar.sendKeys("T shirts");
    }

    public void clickOnSearchButton()
    {
        submitBtn.click();
    }

    public void verifyProduct()
    {
        a.verifyMethod(ldriver, "Faded Short Sleeve T-shirts", productText);
    }
}
