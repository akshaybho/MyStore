package testCases;


import enums.BrowserType;
import org.testng.annotations.Test;
import pageobjects.ColourValidationPage;

import java.io.IOException;


public class ValidateColorTest extends BaseClass {


    @Test
    public void verifyColor() throws InterruptedException, IOException {
        setUp(BrowserType.CHROME);
        ColourValidationPage cvp = new ColourValidationPage(driver);
        cvp.verifyColour();
        tearDown();
    }
}
