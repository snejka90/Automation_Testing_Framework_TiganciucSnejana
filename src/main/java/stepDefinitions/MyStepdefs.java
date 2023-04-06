package stepDefinitions;


import contextManagers.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;


public class MyStepdefs {
    private TestContext testContext;
    public MyStepdefs(TestContext context){
        testContext = context;
    }
    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String adresaURL) {

        testContext.getWebDriverManager().getDriver().get(adresaURL);
        testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(adresaURL);
    }

    @Then("^\"([^\"]*)\" is present within the correct URL")
    public void isPresentWithinTheCorrectURL(String urlKeyWord) {
    Assertions.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(urlKeyWord));
    }
}
