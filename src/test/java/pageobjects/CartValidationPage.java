package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CartValidationPage {

    String selectedItem;
    WebDriver ldriver;
    public CartValidationPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//div[@id ='block_top_menu']/ul/li[3]/a")
    WebElement t_shirts;

    @FindBy(xpath = "//div[@class = 'right-block']/h5/a")
    WebElement itemSelect;

    @FindBy(css = "select#group_1")
    WebElement sizeDropDown;

    @FindBy(xpath = "//button[@name = 'Submit']")
    WebElement addToCart;

    @FindBy(css = "a.btn.btn-default.button.button-medium")
    WebElement proceed;

    @FindBy(xpath = "//td//p[@class = 'product-name']/a")
    WebElement cartProduct;

    public void clickOnTshirts() throws InterruptedException {
        t_shirts.click();
        Thread.sleep(2000);
    }

    public void selectItem() throws InterruptedException {
        selectedItem = itemSelect.getText().trim();
        Thread.sleep(2000);
        itemSelect.click();
    }

    public void chooseSize()
    {
        Select tshirtSize = new Select(sizeDropDown);
        tshirtSize.selectByValue("3");
    }

    public void clickOnAddtoCart()
    {
        addToCart.click();
    }

    public void proceedToCheckOut()
    {
        proceed.click();
    }
    public void cartProductVerify()
    {
        String productInCart = cartProduct.getText();
        if(productInCart.equals(selectedItem))
        {
            Assert.assertTrue(true);
            System.out.println("====PASS====");
        }
        else
        {
            System.out.println("====FAIL====");
            Assert.assertTrue(false);
        }
    }
}
