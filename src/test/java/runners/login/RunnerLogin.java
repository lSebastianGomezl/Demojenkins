package runners.login;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login",
        glue = "stepdefinition.login",
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class RunnerLogin {


}
