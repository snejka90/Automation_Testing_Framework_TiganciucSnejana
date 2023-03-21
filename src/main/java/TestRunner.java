import Managers.WebDriverManager;

public class TestRunner {
    public static void main (String[] args){
        WebDriverManager webDriverManager = new WebDriverManager("CHROME");

        WebDriverManager.getDriver().get("https://www.google.md/");
        WebDriverManager.getDriver().close();
    }
}
