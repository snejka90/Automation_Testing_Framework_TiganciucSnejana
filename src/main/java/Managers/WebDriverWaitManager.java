package Managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WebDriverWaitManager {
    private static WebDriverWait wait;

    public WebDriverWaitManager(WebDriver driver){
        wait = new WebDriverWait(driver,  Duration.ofSeconds(30), Duration.ofSeconds(3000));
    }

    public static void toBeClickable(WebElement element, WebDriver driver){
        if(wait == null) new WebDriverWaitManager(driver);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void toBeVisible(WebElement element, WebDriver driver){
        if(wait == null) new WebDriverWaitManager(driver);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
