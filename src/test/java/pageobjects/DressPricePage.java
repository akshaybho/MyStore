package pageobjects;

import actiondriver.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Utils;

import java.util.ArrayList;
import java.util.List;

public class DressPricePage {

    Action c = new Action();
    WebDriver ldriver;
    public DressPricePage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "(//a[text()='Dresses'])[2]")
    WebElement Dresses;

    @FindBy(css = "select#selectProductSort")
    WebElement dropDown;

    //@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li["+i+"]/div/div[1]/div/div[2]/span[1]")
    //List<WebElement> priceOfDress;

   // @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li["+i+"]/div/div[1]/div/a[1]/img")
    //WebElement img;

    public void clickOnDresses()
    {
        Dresses.click();
    }

    public void selectLowest()
    {
        Select ascList = new Select(dropDown);
        ascList.selectByValue("price:asc");
    }

    public void validateOrderOfPrices() throws InterruptedException {

        String priceData="";
        c.scrollWindow(ldriver);

        for(int i=1; i<6; i++)
        {
            WebElement mouseEle = ldriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]/div/div[1]/div/a[1]/img"));
            c.mouseHoverElement(ldriver, mouseEle);
            Thread.sleep(5000);
             WebElement priceOfDress = ldriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]/div/div[1]/div/div[2]/span[1]"));

           priceData = priceOfDress.getText();

        }
        boolean ascending = Utils.isAscending(priceData);
        if(ascending)
        {
            System.out.println("===============PASS================");
        }
    }
}
