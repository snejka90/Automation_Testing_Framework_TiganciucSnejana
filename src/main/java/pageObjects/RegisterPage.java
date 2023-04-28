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

    @FindBy(xpath = "//*[@id=\"input-telephone\"]")
    private WebElement telephoneInput;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"input-confirm\"]")
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    public WebElement privacyButton;

    @FindBy(xpath = "//input[contains(@value,\"Continue\")]")
    public WebElement continueButton;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String phone, String password, String confirmPass) {
        WebDriverWaitManager.toBeVisible(continueButton, driver);

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        telephoneInput.sendKeys(phone);
        passwordInput.sendKeys(password);
        passwordConfirmInput.sendKeys(confirmPass);
    }

    public void clickPrivacyButton() {
        privacyButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean allTheElementsAreDisplayed() {
        return firstNameInput.isDisplayed() &&
                lastNameInput.isDisplayed() &&
                emailInput.isDisplayed() &&
                telephoneInput.isDisplayed() &&
                passwordInput.isDisplayed() &&
                passwordConfirmInput.isDisplayed() &&
                privacyButton.isDisplayed() &&
                continueButton.isDisplayed();
    }

    public RegisterPage toPage() {
        driver.get(BASER_URL + ENDPOINT);
        return this;
    }
}
