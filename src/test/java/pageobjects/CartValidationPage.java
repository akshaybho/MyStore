package pageobjects;

import constants.CartValidationPageLocators;
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

    @FindBy(xpath = CartValidationPageLocators.T_SHIRTS)
    WebElement t_shirts;

    @FindBy(xpath = CartValidationPageLocators.SELECT_ITEMS)
    WebElement itemSelect;

    @FindBy(css = CartValidationPageLocators.SIZE_OF_DROPDOWN)
    WebElement sizeDropDown;

    @FindBy(xpath = CartValidationPageLocators.ADD_TO_CART)
    WebElement addToCart;

    @FindBy(css = CartValidationPageLocators.PROCEED)
    WebElement proceed;

    @FindBy(xpath = CartValidationPageLocators.PRODUCT_IN_CART)
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
            Assert.fail();
        }
    }
}
