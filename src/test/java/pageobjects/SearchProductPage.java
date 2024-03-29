package pageobjects;

import enums.PageLocators;
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

    @FindBy(id = "search_query_top")
    WebElement searchBar;

    @FindBy(name = "submit_search")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@class='right-block']/h5/a")
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
        String product = productText.getText();
        product.trim();
        String expected = "Faded Short Sleeve T-shirts";
        if(expected.equals(product))
        {
            Assert.assertTrue(true);
        }
    }
}
