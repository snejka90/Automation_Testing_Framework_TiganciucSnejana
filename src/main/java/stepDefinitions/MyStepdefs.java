package stepDefinitions;


import contextManagers.ContextKeys;
import contextManagers.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import pageObjects.Page;

import java.util.List;

import static Managers.WebDriverManager.getDriver;


public class MyStepdefs {
    private TestContext testContext;

    public MyStepdefs(TestContext context) {
        testContext = context;
    }

    private static final Logger logger = LogManager.getLogger(MyStepdefs.class);

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String URL) {

        testContext.getWebDriverManager().getDriver().get(URL);
        testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(URL);
        logger.debug(URL + "Pagina a fost accesata cu succes");
    }

    @Given("^\"([^\"]*)\" is clicked")
    public void isClicked(String pageName) throws Throwable {
        Page.navigateToPage(pageName, testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(ContextKeys.PAGE, pageName);
        logger.info("Metoda toPage a clasei " + pageName + " a fost invocata!");
    }

    @Then("{string} is present within the correct URL")
    public void isPresentWithinTheCorrectURL(String contentKey) {
        boolean isPresentWithinTheCorrectURL = testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(contentKey);
        Assertions.assertTrue(isPresentWithinTheCorrectURL, "The url contains:" + contentKey);
        logger.info("URL contine cuvantul cheie presentat " + contentKey);
    }

    @Then("^the following errors (are|are not) displayed on the screen:$")
    public void theFollowingErrorsAreDisplayedOnTheScreen(String condition, List<String> errorMessages) {
        for (int i = 0; i < errorMessages.size(); i++) {
            boolean elementIsDisplayed = false;
            try {
                String alert = testContext.getWebDriverManager().getDriver().switchTo().alert().getText();
                elementIsDisplayed = true;
            } catch (Exception e) {
                e.printStackTrace();
                logger.warn("Eroarea a fost depistata");
            }
            if (condition.contains("are not"))
                Assert.assertTrue("The error message is not displayed.", elementIsDisplayed);
            else {
                Assert.assertFalse("The error message is displayed.", elementIsDisplayed);
            }
        }
    }

    @Then("{string} is opened")
    public void isOpened(String pageName) {
        Page.navigateToPage(pageName, testContext.getWebDriverManager().getDriver());
        logger.info("Pagina " + pageName + " a fost accesata!");
        testContext.getScenarioContext().setContext(ContextKeys.PAGE, pageName);
    }

}
