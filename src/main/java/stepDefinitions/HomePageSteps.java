package stepDefinitions;

import contextManagers.ContextKeys;
import contextManagers.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.Page;

public class HomePageSteps {
    private TestContext testContext;
    private HomePage homePage;
    public HomePageSteps(TestContext testContext){
        this.testContext = testContext;
        homePage = new HomePage (testContext.getWebDriverManager().getDriver());
    }

    @And("Register button is clicked")
    public void registerButtonIsClicked(String page) {
        Page.navigateToPage(page,testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(ContextKeys.PAGE, page);
    }

    @When("dropdown is displayed$")
    public void dropdownIsDisplayed(String button) {
        Page.clickElement(testContext.getScenarioContext().getContext(ContextKeys.PAGE),
            button,testContext.getWebDriverManager().getDriver());
    }
}
