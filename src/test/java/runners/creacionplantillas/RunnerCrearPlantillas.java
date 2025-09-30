package runners.creacionplantillas;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="classpath:features/creacionplantillas",
        glue = {"stepdefinition.creacionplantillas", "stepdefinition.hooks"},
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerCrearPlantillas {
}
