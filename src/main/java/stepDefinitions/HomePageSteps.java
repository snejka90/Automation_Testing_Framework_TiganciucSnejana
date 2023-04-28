package stepDefinitions;

import contextManagers.ContextKeys;
import contextManagers.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.Page;

public class HomePageSteps {
    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        //homePage = new HomePage (testContext.getWebDriverManager().getDriver());
    }

    @When("{string} button is displayed")
    public void dropdownIsDisplayed(String button) {
        Page.clickElement(testContext.getScenarioContext().getContext(ContextKeys.PAGE),
                button, testContext.getWebDriverManager().getDriver());

    }

    @And("{string} button is clicked")
    public void isClicked(String button) throws InterruptedException {
        Object page = testContext.getScenarioContext().getContext(ContextKeys.PAGE);
        Page.clickElement(page, button, testContext.getWebDriverManager().getDriver());
Thread.sleep(3000);
    }

}
