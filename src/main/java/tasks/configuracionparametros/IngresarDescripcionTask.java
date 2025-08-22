package tasks.configuracionparametros;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import ui.ConfiguracionParametros;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarDescripcionTask implements Task {

    private final String valor;

    public IngresarDescripcionTask(String valor) {
        this.valor = valor;
    }
    public static IngresarDescripcionTask on(String valor) {
        return instrumented(IngresarDescripcionTask.class, valor);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(valor).into(ConfiguracionParametros.DESCRIPCION_PARAMETRO),
                SendKeys.of(Keys.ENTER).into(ConfiguracionParametros.DESCRIPCION_PARAMETRO)
        );
    }
}
