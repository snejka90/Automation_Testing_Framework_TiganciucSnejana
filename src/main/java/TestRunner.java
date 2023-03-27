import Managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.serviceworker.model.RegistrationID;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TestRunner {
    public static void main (String[] args) throws InterruptedException {
        WebDriverManager webDriverManager = new WebDriverManager("CHROME");

        webDriverManager.getDriver().get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(webDriverManager.getDriver());
        registerPage.fillInTheRegisterForm("Snejana", "Tiganciuc","stiganciuc@gmail.com", "creative90");

        Thread.sleep(10000);

        webDriverManager.getDriver().close();
    }
}
