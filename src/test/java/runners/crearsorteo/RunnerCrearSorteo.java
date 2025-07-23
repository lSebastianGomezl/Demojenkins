package runners.crearsorteo;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="src/test/resources/features/crearsorteo",
        glue = "stepdefinition.crearsorteos",
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerCrearSorteo {
}
