package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features",
        glue = "stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/cucumber-reports"}

)

public final class CucumberTestRunner {
}
