package runners.configuracionplanderesultado;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="src/test/resources/features/configuraciondeplanderesultados",
        glue = {"stepdefinition.configuraciondeplanderesultados", "stepdefinition.hooks"},
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerPlanDeResultadoSorteo {
}
