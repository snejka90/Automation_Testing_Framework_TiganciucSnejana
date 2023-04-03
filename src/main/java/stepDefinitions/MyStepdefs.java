package stepDefinitions;

import contextManagers.TestContext;
import io.cucumber.java.en.Given;


public class MyStepdefs {
    private TestContext testContext;
    public MyStepdefs(TestContext context){
        testContext = context;
    }
    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String adresaURL) {
        testContext.getWebDriverManager().getDriver().get(adresaURL);
    }
}
