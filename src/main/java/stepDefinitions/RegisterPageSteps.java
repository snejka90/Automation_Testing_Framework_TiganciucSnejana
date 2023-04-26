package stepDefinitions;

import contextManagers.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterPage;

import java.util.Map;

public class RegisterPageSteps {
    private TestContext testContext;
    private RegisterPage registerPage;

    public RegisterPageSteps(TestContext context){
        testContext = context;
        registerPage = new RegisterPage(testContext.getWebDriverManager().getDriver());
    }

    @When("the register account is populated with below data:")
    public void theRegistrationFormIsPopulatedWithBelowData(Map<String, String> formData) {
        String firstName = formData.get("firstName");
        String lastName = formData.get("lastName");
        String email = formData.get("email");
        String password = formData.get("password");
        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
    }



    @And("continue button is clicked")
    public void continueButtonIsClicked() {
        registerPage.clickContinueButton();
    }
}
