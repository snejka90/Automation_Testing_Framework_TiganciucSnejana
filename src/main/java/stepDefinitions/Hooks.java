package stepDefinitions;


import contextManagers.TestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.*;

public class Hooks {
    private TestContext testContext;
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUpBeforeEachTest() {
        testContext.getWebDriverManager().getDriver();
        logger.info("Browser-ul a fost initializat cu succes!");
    }

    @After
    public void testDownAfterEachTest() {
        testContext.getWebDriverManager().getDriver().close();
        logger.info("Browser-ul a fost inchis!");
    }

}
