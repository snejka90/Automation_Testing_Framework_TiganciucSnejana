package Managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    public WebDriverManager(String webDriverType) {
        this.webDriverType = webDriverType;
    }

    private static WebDriver driver;
    private static String webDriverType;

    private static WebDriver createDriver() {
        switch (webDriverType) {
            case "CHROME":
                System.setProperty("webDriver.chrome.driver", "src/main/resources/drivers/chromedriver_win32.zip.url");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "FIREFOX":
                System.setProperty("webDriver.geckodriver", "src/main/resources/drivers/geckodriver-v0.32.2-win32.zip.url");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Optiunea de web driver indicata nu este valabila' Mai incearca!");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));

        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
            System.out.println("Driver-ul a fost inchis");
        }
    }

    public WebDriverManager() {
        webDriverType = PropertiesManagers.getBrowserType();
    }


}
