package Managers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManagers {
    private static Properties properties;
    public static void initializeProperties(){
        properties = new Properties();
        String propertiesFilePath = "src/main/resources/config.properties";
        try{
            properties.load(new FileReader(propertiesFilePath));
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("test.properties was not found at" + propertiesFilePath);
        }
    }
    public static String getBrowserType(){
        if (properties == null) initializeProperties();
        String browserType = properties.getProperty("browserType");
        if (browserType != null){
            return browserType;
        }else {
            throw new RuntimeException("BrowserType was not found");
        }
    }
    public static String getApplicationURL(){
        if (properties == null) initializeProperties();
        String browserType = properties.getProperty("url");
        if (browserType != null){
            return browserType;
        }else {
            throw new RuntimeException("The app url was not found");
        }
    }
}
