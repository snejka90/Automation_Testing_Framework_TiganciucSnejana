package stepDefinitions;

import contextManagers.TestContext;
import org.junit.After;
import org.junit.Before;

public class Hooks {
    private TestContext testContext;
    public Hooks (TestContext context){
        testContext = context;
    }
    @Before
    public void setUpBeforeEachTest(){
        testContext.getWebDriverManager().getDriver();
    }

    @After
    public void testDownAfterEachTest(){
        testContext.getWebDriverManager().getDriver().close();
    }

}
