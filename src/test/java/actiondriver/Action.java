package actiondriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import testCases.BaseClass;

public class Action extends BaseClass {


    public boolean mouseHoverElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            Actions a = new Actions(driver);
            a.moveToElement(ele).perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean scrollWindow(WebDriver driver) {
        boolean flag = false;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,900)", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean selectByValue(WebElement ele, String value) {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByValue(value);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean selectByVisibleText(String visibletext, WebElement ele) {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByVisibleText(visibletext);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean launchURL(WebDriver driver, String url)
    {
        boolean flag = false;
        try
        {
            driver.navigate().to(url);
            flag = true;
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public boolean verifyMethod(WebDriver driver, String data, WebElement ele)
    {
        boolean flag = false;
        try
        {
            String actual = ele.getText();
            if(actual.equals(data))
            {
                Assert.assertTrue(true);
                flag = true;
                return true;
            }
            else
            {
                Assert.fail();
                return false;
            }

        }
        catch(Exception e)
        {
            return false;
        }
    }
}



