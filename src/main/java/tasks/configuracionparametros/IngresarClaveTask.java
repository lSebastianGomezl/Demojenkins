package tasks.configuracionparametros;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import ui.ConfiguracionParametros;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarClaveTask implements Task {

    private final String valor;

    public IngresarClaveTask(String valor) {
        this.valor = valor;
    }
    public static IngresarClaveTask on(String valor) {
        return instrumented(IngresarClaveTask.class, valor);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //Click.on(ConfiguracionParametros.CAMPO_BUSQUEDA),
                Enter.theValue(valor).into(ConfiguracionParametros.CAMPO_BUSQUEDA),
                SendKeys.of(Keys.ENTER).into(ConfiguracionParametros.CAMPO_BUSQUEDA)
        );
    }
}
