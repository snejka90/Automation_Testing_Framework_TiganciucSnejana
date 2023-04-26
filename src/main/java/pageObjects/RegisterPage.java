package pageObjects;

import Managers.WebDriverWaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends Page {
    private final String ENDPOINT = "/index.php?route=account/register";

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"input-firstname\"]")
    private WebElement firstNameInput;
    @FindBy(xpath = "//*[@id=\"input-lastname\"]")
    private WebElement lastNameInput;
    @FindBy(xpath = "//*[@id=\"input-email\"]")
    private WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"input-password\"]")
    private WebElement passwordInput;
    //    @FindBy (xpath = "//*[@id=\"input-newsletter-no\"]")
//    public WebElement RadioButton;
//    @FindBy (xpath = "//*[@id=\"form-register\"]/div/div/div/input")
//    public WebElement privacyButton;
    @FindBy(xpath = "//input[contains(@value,\"Continue\")]")
    public WebElement continueButton;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password) {
        WebDriverWaitManager.toBeVisible(continueButton, driver);

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean allTheElementsAreDisplayed() {
        return firstNameInput.isDisplayed() && lastNameInput.isDisplayed() && emailInput.isDisplayed() &&
                passwordInput.isDisplayed() &&
                continueButton.isDisplayed();
    }

    public RegisterPage toPage() {
        driver.get(BASER_URL + ENDPOINT);
        return this;
    }
}
