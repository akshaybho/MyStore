package testCases;

import org.testng.annotations.Test;
import pageobjects.ColourValidationPage;

public class ValidateColorTest extends BaseClass {

    @Test
    public void verifyColor() throws InterruptedException {
        ColourValidationPage cvp = new ColourValidationPage(driver);
        cvp.verifyColour();
    }
}
