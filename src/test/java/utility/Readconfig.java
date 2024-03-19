package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {

    Properties prop;
    String Path = System.getProperty("user.dir")+"/Configuration/Config.properties";

    public Readconfig()
    {
        try {
        prop = new Properties();

            FileInputStream input = new FileInputStream(Path);

            prop.load(input);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getBaseUrl()
    {
        String value = prop.getProperty("baseUrl");

        if(value!=null){
            return value;
        }
        else{
            throw new RuntimeException("URL is not specified in Config file");
        }
    }

    public String getBrowser()
    {
        String value = prop.getProperty("browser");

        if(value!=null){
            return value;
        }
        else{
            throw new RuntimeException("Browser is not specified in Config file");
        }
    }

    public String readDay()
    {
        String bday = prop.getProperty("day");
        return bday;
    }
    public String readMonth()
    {
        String bmonth = prop.getProperty("month");
        return bmonth;
    }

    public String readYear()
    {
        String byear = prop.getProperty("year");
        return byear;
    }


}
