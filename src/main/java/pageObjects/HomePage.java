package pageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    private final  String ENDPOINT = "/index.php?route=common/home";
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void clickOnMyAccountButton(){
        myAccountButton.click();
    }
    public void clickOnRegisterButton(){
        registerButton.click();
    }


    public HomePage toPage(){
        driver.get(BASER_URL + ENDPOINT);
        return this;
    }
}
