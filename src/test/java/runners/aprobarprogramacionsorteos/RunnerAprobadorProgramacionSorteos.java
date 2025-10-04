package runners.aprobarprogramacionsorteos;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="classpath:features/aprobarprogramacionsorteos",
        glue = {"stepdefinition.aprobarprogramacionsorteos", "stepdefinition.hooks"},
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerAprobadorProgramacionSorteos {
}
