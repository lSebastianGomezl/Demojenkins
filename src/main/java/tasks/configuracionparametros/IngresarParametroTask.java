package tasks.configuracionparametros;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import ui.ConfiguracionParametros;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarParametroTask implements Task {

    private final String valor;

    public IngresarParametroTask(String valor) {
        this.valor = valor;
    }
    public static IngresarParametroTask on(String valor) {
        return instrumented(IngresarParametroTask.class, valor);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(valor).into(ConfiguracionParametros.NOMBRE_PARAMETRO),
                SendKeys.of(Keys.ENTER).into(ConfiguracionParametros.NOMBRE_PARAMETRO)
        );
    }
}
