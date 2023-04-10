package contextManagers;

import Managers.PropertiesManagers;
import Managers.WebDriverManager;

public class TestContext {

    private WebDriverManager webDriverManager;
    private ScenarioContext scenarioContext;
    public TestContext(){
        webDriverManager = new WebDriverManager(PropertiesManagers.getBrowserType());
        scenarioContext = ScenarioContext.getInstance();
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }
    public ScenarioContext getScenarioContext(){
        return scenarioContext;
    }
}
