package actiondriver;

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
        finally
        {
            if(flag)
            {
                System.out.println("MouseHover action is performed");
            }
            else
            {
                System.out.println("MouseHover action is not performed");
            }
        }
        return flag;
    }
}
