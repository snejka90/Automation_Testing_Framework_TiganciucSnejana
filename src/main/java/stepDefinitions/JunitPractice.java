package stepDefinitions;

import Managers.WebDriverManager;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class JunitPractice {

    WebDriverManager webDriverManager = new WebDriverManager("CHROME");
 @BeforeEach
 public void beforeTestProcedure(){
     webDriverManager.getDriver().get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
 }

 @AfterEach
 public void afterTestProcedure(){
     webDriverManager.getDriver().close();
 }

    @Test
    @DisplayName("Adresa URL a paginii Register este disponibila din pagina Home")
    public void verifyIfTheRegisterPageIsAccesible(){

        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        boolean urlValid = webDriverManager.getDriver().getCurrentUrl().contains("register");

        Assertions.assertTrue(urlValid, "Adreswa URL nu este valida");
    }
    @Test
    @DisplayName ("Elementele paginii sunt disponibile")
    public void registerPageAreDisplayed(){

        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(webDriverManager.getDriver());

        Assertions.assertTrue(registerPage.allTheElementsAreDispalyed(),"Cel putin unul dintre elemente nu a fost afisat");
    }
}
