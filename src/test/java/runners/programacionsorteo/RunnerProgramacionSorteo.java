package runners.programacionsorteo;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="classpath:features/programacionsorteo",
        glue = {"stepdefinition.programacionsorteo", "stepdefinition.hooks"},
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerProgramacionSorteo {
}
