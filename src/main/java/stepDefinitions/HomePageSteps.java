package stepDefinitions;

import contextManagers.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps {
    private TestContext testContext;
    private HomePage homePage;
    public HomePageSteps(TestContext testContext){
        this.testContext = testContext;
        homePage = new HomePage (testContext.getWebDriverManager().getDriver());
    }

    @When("dropdown is displayed")
    public void dropdownIsDisplayed() {
        homePage.clickOnMyAccountButton();
    }

    @And("Register button is clicked")
    public void registerButtonIsClicked() {
        homePage.clickOnRegisterButton();
    }
}
