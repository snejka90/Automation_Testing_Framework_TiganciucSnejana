package stepDefinitions;

import Managers.WebDriverManager;
import org.junit.jupiter.api.Test;
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
     webDriverManager.getDriver().get("https://demo.opencart.com/");
 }

 @AfterEach
 public void afterTestProcedure(){
     webDriverManager.getDriver().close();
 }

    @Test
    @DisplayName("Adresa URL a paginii Register este disponibila din pagina Home")
    public void verifyIfTheRegisterPageIsAccessible(){

        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        boolean urlValid = webDriverManager.getDriver().getCurrentUrl().contains("register");

       Assertions.assertTrue(urlValid, "Adresa URL nu este valida");
        webDriverManager.getDriver().close();
    }
    @Test
    @DisplayName ("Elementele paginii sunt disponibile")
    public void registerPageAreDisplayed(){

        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(webDriverManager.getDriver());

        Assertions.assertTrue(registerPage.allTheElementsAreDisplayed(),"Cel putin unul dintre elemente nu a fost afisat");
    }
}
