package tasks.configuracionparametros;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import ui.ConfiguracionParametros;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarOpcionEmpresaTask implements Task {

    private final String valor;

    public IngresarOpcionEmpresaTask(String valor) {
        this.valor = valor;
    }
    public static IngresarOpcionEmpresaTask on(String valor) {
        return instrumented(IngresarOpcionEmpresaTask.class, valor);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ConfiguracionParametros.OPCION_EMPRESA(valor))

        );
    }
}
