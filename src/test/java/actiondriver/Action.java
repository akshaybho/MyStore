package actiondriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testCases.BaseClass;

public class Action extends BaseClass {

    public boolean mouseHoverElement(WebDriver driver, WebElement ele)
    {
        boolean flag = false;
        try
        {
            Actions a = new Actions(driver);
            a.moveToElement(ele).perform();
            flag = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean scrollWindow(WebDriver driver)
    {
        boolean flag = false;
        try
        {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,900)","");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return flag;
    }
}
