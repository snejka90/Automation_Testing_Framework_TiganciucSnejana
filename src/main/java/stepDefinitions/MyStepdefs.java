package stepDefinitions;


import contextManagers.ContextKeys;
import contextManagers.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.Page;

import java.util.List;
import java.util.Map;


public class MyStepdefs {
    private TestContext testContext;

    public MyStepdefs(TestContext context) {
        testContext = context;
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String URL) {

        testContext.getWebDriverManager().getDriver().get(URL);
        testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(URL);
    }

    @Given("^\"([^\"]*)\" is clicked")
    public void isClicked(String pageName) throws Throwable {
        Page.navigateToPage(pageName, testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(ContextKeys.PAGE, pageName);
    }

    @Then("{string} is present within the correct URL")
    public void isPresentWithinTheCorrectURL(String contentKey) {
        boolean isPresentWithinTheCorrectURL = testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(contentKey);
        Assertions.assertTrue(isPresentWithinTheCorrectURL, "The url contains:" + contentKey);
    }

    @Then("^the following errors (are|are not) displayed on the screen:$")
    public void theFollowingErrorsAreDisplayedOnTheScreen(String condition, List<String> errorMessages) {
        for (int i = 0; i < errorMessages.size(); i++) {
            boolean elementIsDisplayed = true;
            try {
                String alertMessage = testContext.getWebDriverManager().getDriver().switchTo().alert().getText();
                elementIsDisplayed = false;
            }catch (Exception e){
                e.printStackTrace();
            }
            if (condition.contains("are not"))
                Assert.assertFalse("The error message is not displayed.", elementIsDisplayed);
            else{
                Assert.assertTrue("The error message is displayed.", elementIsDisplayed);
            }
        }
    }

    @Then("{string} is opened")
    public void isOpened(String registerBtn) {
        Page.navigateToPage(registerBtn, testContext.getWebDriverManager().getDriver());
        System.out.println("Pagina" + registerBtn + "a fost accesata!");
    }

}
