package pageObjects;

import Managers.PropertiesManagers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
//import java.lang.reflect.Method;

public abstract class Page {
    protected WebDriver driver;

    protected static final Logger logger = LogManager.getLogger(Page.class);

    protected final String BASER_URL = PropertiesManagers.getApplicationURL();

    public Page(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/a/span")
    protected WebElement myAccountButton;
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")
    protected WebElement registerButton;

    public void navigateToRegisterPage() {
        myAccountButton.click();
        logger.info("MyAccountButton is clicked");
        registerButton.click();
    }

    public static void navigateToPage(String pageName, WebDriver driver) {
        Method method;
        try {
            method = Class.forName("pageObjects." + pageName).getMethod("toPage");
            method.invoke(Class.forName("pageObjects." + pageName).getConstructor(WebDriver.class).newInstance(driver));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickElement(Object pageName, String elementName, WebDriver driver) {
        WebElement webElement;
        Class clazz = null;
        try {
            clazz = Class.forName("pageObjects." + pageName.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields)
            if (field.getType() == WebElement.class) {
                field.setAccessible(true);
                if (field.getName().equals(elementName))
                    try {
                        webElement = (WebElement) field.get(clazz.getConstructor(WebDriver.class).newInstance(driver));
                        webElement.click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
    }
    public Page toPage(){
        driver.getCurrentUrl();
        return this;
    }
}
