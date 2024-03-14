package utility;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import java.util.UUID;

public class Utils {


    public String generateEmail()
    {
        String uuid = UUID.randomUUID().toString();

        String email = "user_"+ uuid.substring(0,8)+"@gmail.com";

        return email;
    }

    public static String generateSecurePassword()
    {
        CharacterRule LCR = new CharacterRule(EnglishCharacterData.LowerCase);
        LCR.setNumberOfCharacters(2);

        CharacterRule UCR = new CharacterRule(EnglishCharacterData.UpperCase);
        UCR.setNumberOfCharacters(2);

        CharacterRule DR = new CharacterRule(EnglishCharacterData.Digit);
        DR.setNumberOfCharacters(2);

        CharacterRule SR = new CharacterRule(EnglishCharacterData.Special);
        SR.setNumberOfCharacters(2);

        PasswordGenerator passGen = new PasswordGenerator();

        String password = passGen.generatePassword(8, SR, DR, LCR, UCR);

        return password;
    }
}
