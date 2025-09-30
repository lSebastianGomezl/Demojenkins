package runners.configuracionparametros;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="classpath:features/configuraciondeparametros",
        glue = {"stepdefinition.configuracionparametros", "stepdefinition.hooks"},
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerConfiguracionParametros {
}
