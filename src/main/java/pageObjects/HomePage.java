package pageObjects;

import Managers.WebDriverWaitManager;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    private final  String ENDPOINT = "/index.php?route=common/home";
    public HomePage(WebDriver driver) {

        super(driver);
    }
    public void clickOnMyAccountButton(){

        WebDriverWaitManager.toBeVisible(myAccountButton, driver);
        myAccountButton.click();
    }
    public void clickOnRegisterButton(){
        WebDriverWaitManager.toBeVisible(registerButton, driver);
        registerButton.click();
    }


    public HomePage toPage (){
        driver.get(BASER_URL + ENDPOINT);
        return this;
    }
}
