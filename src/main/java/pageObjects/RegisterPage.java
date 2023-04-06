package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class RegisterPage extends Page {


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id=\"input-firstname\"]")
    private WebElement firstNameInput;
    @FindBy (xpath = "//*[@id=\"input-lastname\"]")
    private WebElement lastNameInput;
    @FindBy (xpath = "//*[@id=\"input-email\"]")
    private WebElement emailInput;
    @FindBy (xpath = "//*[@id=\"input-password\"]")
    private WebElement passwordInput;
    @FindBy (xpath = "//*[@id=\"input-newsletter-no\"]")
    public WebElement RadioButton;
    @FindBy (xpath = "//*[@id=\"form-register\"]/div/div/div/input")
    public WebElement privacyButton;
    @FindBy (xpath = "//*[@id=\"form-register\"]/div/div/button")
    public WebElement continueButton;

    public void fillInTheRegisterForm(String firstName,String lastName, String email, String password){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public boolean allTheElementsAreDisplayed (){
        return firstNameInput.isDisplayed() && lastNameInput.isDisplayed() && emailInput.isDisplayed() && passwordInput.isDisplayed() && RadioButton.isDisplayed() &&privacyButton.isDisplayed() && continueButton.isDisplayed();
    }
}
